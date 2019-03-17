package com.xupt.hamster.service;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.pojo.Student;
import com.xupt.hamster.vo.StudentLogin;
import com.xupt.hamster.vo.StudentRegist;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maxu
 * @date 2019/3/16
 */
public interface StudentService {
    ResultMap studentLogin(StudentLogin userLogin);

    ResultMap regist(StudentRegist studentRegist);

    Student getByUserName(String username);

    ResultMap updateUser(Student student, HttpServletRequest request);

    ResultMap sendMail(String email, Student student, HttpServletRequest request);

    ResultMap changeUserPassword(Student student, String oldPassword, String password, HttpServletRequest request);

}
