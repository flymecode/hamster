package com.xupt.hamster.pojo;

import lombok.Data;

/**
 * 问卷
 * @author maxu
 * @date 2019/3/17
 */
@Data
public class Questionnaire {
    /**
     * 问卷id
     */
    private Integer id;
    /**
     * 学号id
     */
    private Integer studentId;
    /**
     * 教师id
     */
    private Integer teacherId;
    /**
     * 课程id
     */
    private Integer courseId;

}
