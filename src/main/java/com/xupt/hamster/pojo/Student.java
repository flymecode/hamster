package com.xupt.hamster.pojo;

import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public class Student {

    private Integer id;
    // 学号
    private String sno;
    private String studentName;
    private String name;
    // 班级
    private String grade;
    private String password;
    // 学院
    private String academy;
}
