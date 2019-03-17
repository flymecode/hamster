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


    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 是否评教
     */
    private Boolean state = false;

    private Integer majorId;
    private Date updateTime;
    private Date createTime;
}
