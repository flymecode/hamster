package com.xupt.hamster.service.impl;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.mapper.QuestionMapper;
import com.xupt.hamster.pojo.Question;
import com.xupt.hamster.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author Gary
 * @date 2019/03/17
 */
@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public ResultMap getAllQuestion() {
        //List<Question> list = questionMapper.getAllQuestion();
        List<Question> list = new ArrayList<>();
        Question question = new Question();
        question.setTypeName("test");
        list.add(question);
        ResultMap resultMap = new ResultMap();
        resultMap.payloads(list);
        return resultMap;
    }
}
