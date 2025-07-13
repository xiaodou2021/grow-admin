package com.ig.game_admin.common;

import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.config.MagicFunction;
import org.ssssssss.script.annotation.Comment;
import org.ssssssss.script.annotation.Function;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class MyCustomFunction implements MagicFunction {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Function
    @Comment("生成长整型唯一ID按时间戳")
    public Long generateTimestampUniqueId(){
        return System.currentTimeMillis();
    }
    @Function
    @Comment("生成长整型唯一ID按雪花算法")
    public Long generateSnowflakeUniqueId(){
        return IdUtil.getSnowflakeNextId();
    }
    @Function
    @Comment("生成字符串唯一ID按雪花算法")
    public String generateSnowflakeUniqueIdStr(){
        return IdUtil.getSnowflakeNextIdStr();
    }

    @Function
    @Comment("判断空值")
    public boolean ifNull(String val){
        return StringUtils.isBlank(val);
    }

    @Function
    @Comment("生成当前日期")
    public Date currentDate(){
        return new Date();
    }

    @Function
    @Comment("生成登录token")
    public String generateToken(String userAccount) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(userAccount)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    @Function
    @Comment("检验token")
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Function
    @Comment("缓存对象信息")
    public void cacheUser(String key,Object data) {
        redisTemplate.opsForValue().set(key, data);
    }

    @Function
    @Comment("查询缓存对象")
    public Object getDataFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    private static final String[] IP_HEADERS = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };
    @Function
    @Comment("获取客户端IP")
    public static String getClientIp(HttpServletRequest request) {
        if (request == null) {
            return "0.0.0.0";
        }

        // 1. 检查所有可能的头信息
        for (String header : IP_HEADERS) {
            String ipList = request.getHeader(header);
            if (StringUtils.isNotEmpty(ipList) && !"unknown".equalsIgnoreCase(ipList)) {
                // 2. 处理X-Forwarded-For的多IP情况
                if ("X-Forwarded-For".equalsIgnoreCase(header)) {
                    return ipList.split(",")[0].trim();
                }
                return ipList.trim();
            }
        }

        // 3. 回退到request.getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();

        // 4. 处理IPv6本地地址
        if ("0:0:0:0:0:0:0:1".equals(remoteAddr)) {
            return "127.0.0.1";
        }

        return remoteAddr;
    }
}
