package com.xupt.hamster.service.impl;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.mapper.StudentMapper;
import com.xupt.hamster.service.StudentService;
import com.xupt.hamster.vo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResultMap studentLogin(UserLogin userLogin) {
        return null;
    }
}
