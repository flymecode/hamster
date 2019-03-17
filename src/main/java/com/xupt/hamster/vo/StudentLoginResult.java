package com.xupt.hamster.vo;

import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/17
 */
@Data
public class StudentLoginResult {
    private Integer id;
    // 姓名
    private String name;
    // 班级
    private String grade;
    // 学院
    private String academy;
    // 专业
    private String major;
    // 邮箱
    private String email;
    // 是否评教
    private Boolean sure = false;
}
