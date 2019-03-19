package com.xupt.hamster.controller;

import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.core.enums.HttpCodeEnum;
import com.xupt.hamster.service.StudentService;
import com.xupt.hamster.vo.StudentLogin;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Slf4j
@RestController
@RequestMapping(Constants.BASE_API_PATH + "/")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/login")
    @ApiOperation(value = "Login into the server and return token")
    public ResponseEntity login(@Valid @RequestBody StudentLogin studentLogin, @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResultMap resultMap = new ResultMap().fail().message(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return ResponseEntity.status(resultMap.getCode()).body(resultMap);
        }
        try {
            ResultMap resultMap = studentService.studentLogin(studentLogin);
            return ResponseEntity.status(resultMap.getCode()).body(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return ResponseEntity.status(HttpCodeEnum.SERVER_ERROR.getCode()).body(HttpCodeEnum.SERVER_ERROR.getMessage());
        }
    }
}
