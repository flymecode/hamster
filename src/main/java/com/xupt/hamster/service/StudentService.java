package com.xupt.hamster.service;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.vo.UserLogin;

/**
 * @author maxu
 * @date 2019/3/16
 */
public interface StudentService {
    ResultMap studentLogin(UserLogin userLogin);
}
