package com.xupt.hamster.pojo;

import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public class Teacher {

    /**
     * 老师id
     */
    private String id;
    /**
     * 老师名称
     */
    private String name;
    /**
     * 老师账户
     */
    private String username;
    /**
     * 老师密码
     */
    private String password;
}
