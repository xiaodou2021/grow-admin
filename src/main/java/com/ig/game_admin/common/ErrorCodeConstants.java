package com.ig.game_admin.common;

public class ErrorCodeConstants {
    public static final String SUCCESS_CODE = "20000";
    public static final String SUCCESS_CODE_MSG = "SUCCESS";

    public static final String ACCOUNT_REPEAT_ERROR_CODE = "40000";
    public static final String ACCOUNT_REPEAT_ERROR_CODE_MSG = "账号已存在，请更换后重试";

    public static final String ACCOUNT_NOT_EXIST_ERROR_CODE = "40001";
    public static final String ACCOUNT_NOT_EXIST_ERROR_CODE_MSG = "账户不存在，请注册后重试";

    public static final String LOGIN_PASSWORD_ERROR_CODE = "40002";
    public static final String LOGIN_PASSWORD_ERROR_CODE_MSG = "登录密码错误，请修改后重试";

    public static final String ACCOUNT_FORBIDDEN_ERROR_CODE = "40003";
    public static final String ACCOUNT_FORBIDDEN_ERROR_CODE_MSG = "用户被禁用，请联系管理员";

    public static final String NOT_LOGIN_ERROR_CODE = "40004";
    public static final String NOT_LOGIN_ERROR_CODE_MSG = "无效的访问请求";

    public static final String TOKEN_INVALID_ERROR_CODE = "40005";
    public static final String TOKEN_INVALID_ERROR_CODE_MSG = "token已失效，请重新获取";

    public static final String NOT_FOUND_ERROR_CODE = "40006";
    public static final String NOT_FOUND_ERROR_CODE_MSG = "要找的数据不存在";

    public static final String NOT_AUTHORIZED_ERROR_CODE = "40007";
    public static final String NOT_AUTHORIZED_ERROR_CODE_MSG = "无权限访问";

    public static final String NOT_SUPPORT_ERROR_CODE = "40008";
    public static final String NOT_SUPPORT_ERROR_CODE_MSG = "不支持的操作";

    public static final String ADD_FAILED_ERROR_CODE = "40009";
    public static final String ADD_FAILED_ERROR_CODE_MSG = "新增操作失败";

    public static final String EDIT_FAILED_ERROR_CODE = "40010";
    public static final String EDIT_FAILED_ERROR_CODE_MSG = "更新操作失败";

    public static final String UPGRADE_FAILED_ERROR_CODE = "40011";
    public static final String UPGRADE_FAILED_ERROR_CODE_MSG = "卡牌升级失败";
}
