package com.xupt.hamster.service;

import com.xupt.hamster.pojo.Course;

/**
 * @author maxu
 * @date 2019/3/17
 */
public interface CourseService {
    /**
     * 课程的id
     * @param sid
     * @return
     */
    Course getAllCourse(Integer sid);
}
