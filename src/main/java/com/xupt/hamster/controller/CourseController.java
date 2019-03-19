package com.xupt.hamster.controller;

import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.service.CourseService;
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

//    @Autowired
//    private CourseService courseService;

    @GetMapping("/{sid}")
    public ResponseEntity getAllCourse(@PathVariable("sid") Integer sid) {
        return null;
    }
}
