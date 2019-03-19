package com.xupt.hamster.service;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.vo.QuestionResult;

/**
 * describe:问题接口
 *
 * @author Gary
 * @date 2019/3/17
 */
public interface QuestionService {
    /**
     * 得到所有问题
     */
    ResultMap getAllQuestion();

    ResultMap saveQuestionResult(QuestionResult questionResult);
}
