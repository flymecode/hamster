package com.xupt.hamster.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author maxu
 * @date 2019/3/19
 */
@Data
public class QuestionResult {

    /**
     * 学号id
     */
    @NotBlank(message = "studentId is not empty")
    private String studentId;
    /**
     * 教师id
     */
    @NotBlank(message = "teacherId is not empty")
    private Integer teacherId;
    /**
     * 课程id
     */
    @NotBlank(message = "courseId is not empty")
    private Integer courseId;

    @NotBlank(message = "questions is not empty")
    List<Question> questions;
}
