package com.xupt.hamster.mapper;

import com.xupt.hamster.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Mapper
public interface StudentMapper {
    @Select("select * from dp_student where studentId = #{studentId}")
    Student selectByUserName(@Param("studentId") String username);

    @Select("select count(*) from dp_student where studentId = #{studentId}")
    Long getIdByUserName(@Param("studentId") String name);

    @Insert("insert into dp_student (studentId,password) values(#{studentId},#{password})")
    int insert(Student student);

    int changePassword(Student student);
}
