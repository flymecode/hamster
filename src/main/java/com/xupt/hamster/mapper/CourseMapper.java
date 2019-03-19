package com.xupt.hamster.mapper;

import com.xupt.hamster.service.model.StudentModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author maxu
 * @date 2019/3/19
 */
public interface CourseMapper {
    @Select("select a.student_id, a.course_id, b.`name` as course_name, a.teacher_id, c.`name` as teacher_name from dp_sele_course a, dp_course b, dp_teacher c\n" +
            "where \n" +
            "a.course_id=b.id\n" +
            "and a.teacher_id=c.id\n" +
            "and a.student_id=#{sid}")
    List<StudentModel> getAllCourse(@Param("sid") String sid);
}
