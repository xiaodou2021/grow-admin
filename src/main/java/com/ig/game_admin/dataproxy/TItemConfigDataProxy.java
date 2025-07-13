package com.ig.game_admin.dataproxy;

import cn.hutool.core.util.IdUtil;
import com.ig.game_admin.entity.TItemConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.upms.service.EruptUserService;

import java.util.Date;

@Component
public class TItemConfigDataProxy implements DataProxy<TItemConfigEntity> {
    @Autowired
    private EruptUserService eruptUserService;
    @Override
    public void beforeAdd(TItemConfigEntity tItemConfigEntity) {
        String no = IdUtil.getSnowflake(1).nextIdStr();
        tItemConfigEntity.setNo(no);
        tItemConfigEntity.setCreateUser(eruptUserService.getCurrentEruptUser().getCreateUser());
        tItemConfigEntity.setUpdateUser(eruptUserService.getCurrentEruptUser().getUpdateUser());
        Date now = new Date();
        tItemConfigEntity.setCreateTime(now);
        tItemConfigEntity.setUpdateTime(now);
    }

    @Override
    public void beforeUpdate(TItemConfigEntity tItemConfigEntity) {
        Date now = new Date();
        tItemConfigEntity.setUpdateTime(now);
        tItemConfigEntity.setUpdateUser(eruptUserService.getCurrentEruptUser().getUpdateUser());
    }
}
