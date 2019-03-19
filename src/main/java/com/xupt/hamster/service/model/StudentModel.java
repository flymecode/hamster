package com.xupt.hamster.service.model;

import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/19
 */
@Data
public class StudentModel {
    private String studentId;
    private Integer courseId;
    private Integer teacherId;
    private String courseName;
    private String teacherName;

}
