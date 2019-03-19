package com.xupt.hamster.service;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.pojo.Question;

import java.util.List;

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
}
