package com.xupt.hamster.controller;

import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe:
 *
 * @author Gary
 * @date 2019/03/17
 */
@RestController
@Slf4j
@RequestMapping(Constants.BASE_API_PATH + "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation("get all course")
    @GetMapping("")
    public ResponseEntity getAllCourse() {
        ResultMap resultMap = questionService.getAllQuestion();
        return ResponseEntity.status(resultMap.getCode()).body(resultMap);
    }

}
