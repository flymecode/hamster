package com.xupt.hamster.pojo;

import com.xupt.hamster.core.model.TokenDetail;
import lombok.Data;

import java.util.Date;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public class Student extends TokenDetail {

    private Integer id;
    private Integer majorId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 班级
     */
    private String grade;
    /**
     * 学院
     */
    private String academy;
    /**
     * 专业
     */
    private String major;
    /**
     * 是否评教
     */
    private Boolean state = false;

    private Date updateTime;
    private Date createTime;
}
