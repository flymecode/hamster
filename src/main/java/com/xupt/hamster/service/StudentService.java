package com.xupt.hamster.service;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.vo.StudentLogin;
import com.xupt.hamster.vo.StudentRegist;

/**
 * @author maxu
 * @date 2019/3/16
 */
public interface StudentService {
    ResultMap studentLogin(StudentLogin userLogin);

    ResultMap regist(StudentRegist studentRegist);
}
