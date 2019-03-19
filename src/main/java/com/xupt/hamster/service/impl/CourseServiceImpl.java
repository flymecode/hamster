package com.xupt.hamster.service.impl;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.mapper.CourseMapper;
import com.xupt.hamster.mapper.SeleCourseMapper;
import com.xupt.hamster.mapper.TeacherMapper;
import com.xupt.hamster.service.CourseService;
import com.xupt.hamster.service.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maxu
 * @date 2019/3/19
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SeleCourseMapper seleCourseMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public ResultMap getAllCourse(String  sid) {
        ResultMap resultMap = new ResultMap();
        List<StudentModel> allCourse = courseMapper.getAllCourse(sid);
        return resultMap.payloads(allCourse);
    }
}
