package com.xupt.hamster.mapper;

import com.xupt.hamster.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Mapper
public interface QuestionMapper {

    @Select("select * from dp_question")
    List<Question> getAllQuestion();

    @Select("select * from dp_question where questionId = #{questionId}")
    Question getQuestionById(@Param("questionId") String id);

}
