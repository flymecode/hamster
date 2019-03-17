package com.xupt.hamster.pojo;

import lombok.Data;

import java.util.List;

/**
 * 问卷
 * @author maxu
 * @date 2019/3/17
 */
@Data
public class Questionnaire {

    private Integer teacherId;
    private Integer courseId;
    private Integer majorId;
    List<Question> question;
}
