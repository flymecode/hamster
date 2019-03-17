package com.xupt.hamster.core.common;

/**
 * @author maxu
 * @date 2019/3/16
 */
public class Constants {
    /**
     * 访问前缀
     */
    public static final String BASE_API_PATH = "/xupt/";
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "111111";
    /**
     * Token 前缀
     */
    public static final String TOKEN_PREFIX = "Bearer";

    /**
     * Token header名称
     */
    public static final String TOKEN_HEADER_STRING = "Authorization";

    /**
     * Token 用户名
     */
    public static final String TOKEN_USER_NAME = "token_user_name";

    /**
     * Token 密码
     */
    public static final String TOKEN_USER_PASSWORD = "token_user_password";

    /**
     * Token 创建时间
     */
    public static final String TOKEN_CREATE_TIME = "token_create_time";

    /**
     * 邮箱格式
     */
    public static final String REG_EMAIL_FORMAT = "^[a-z_0-9.-]{1,64}@([a-z0-9-]{1,200}.){1,5}[a-z]{1,6}$";
    /**
     * 用户激活 / 重发激活邮件模板
     */
    public static final String USER_ACTIVATE_EMAIL_TEMPLATE = "mail/userActivateEmailTemplate";

    /**
     * 用户激活 / 重发激活邮件主题
     */
    public static final String USER_ACTIVATE_EMAIL_SUBJECT = "[Davinci] 用户激活";
    /**
     * 敏感sql操作
     */
    public static final String REG_SENSITIVE_SQL = "drop\\s|alert\\s|grant\\s|delete\\s|update\\s|remove\\s";

    /**
     * 匹配多行sql注解正则
     */
    public static final String REG_SQL_ANNOTATE = "(?ms)('(?:''|[^'])*')|--.*?$|/\\*.*?\\*/";
    /**
     * 匹配密码
     */
    public static final String REG_USER_PASSWORD = ".{6,20}";
    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "CURRENT_USER";
}
