package com.xupt.hamster.controller;

import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.service.QuestionService;
import com.xupt.hamster.vo.QuestionResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
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
    @GetMapping
    public ResponseEntity getAllQuestion() {
        ResultMap resultMap = questionService.getAllQuestion();
        return ResponseEntity.status(resultMap.getCode()).body(resultMap);
    }

    @ApiOperation("insert into question")
    @PostMapping
    public ResponseEntity saveQuestion(@Valid @RequestBody List<QuestionResult> questionResults, @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResultMap resultMap = new ResultMap().fail().message(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return ResponseEntity.status(resultMap.getCode()).body(resultMap);
        }
        ResultMap resultMap = questionService.saveQuestionResult(questionResults);
        return ResponseEntity.status(resultMap.getCode()).body(resultMap);
    }

}
