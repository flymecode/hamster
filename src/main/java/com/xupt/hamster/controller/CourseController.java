package com.xupt.hamster.controller;

import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maxu
 * @date 2019/3/17
 */
@RestController
@Slf4j
@RequestMapping(Constants.BASE_API_PATH + "course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{sid}")
    @ApiOperation("get all course")
    public ResponseEntity getAllCourse(@PathVariable("sid") String sid) {
        ResultMap allCourse = courseService.getAllCourse(sid);
        return ResponseEntity.status(allCourse.getCode()).body(allCourse);
    }
}
