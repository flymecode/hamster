package com.xupt.hamster.pojo;

import lombok.Data;

/**
 * describe:问题
 *
 * @author Gary
 * @date 2019/03/17
 */
@Data
public class Question {

    /**
     * 问题id
     */
    private Integer id;
    /**
     * 问题类型
     */
    private String typeName;
    /**
     * 问题内容
     */
    private String context;


}
