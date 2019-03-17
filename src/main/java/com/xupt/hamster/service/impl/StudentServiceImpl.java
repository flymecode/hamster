package com.xupt.hamster.service.impl;

import com.xupt.hamster.core.common.ResultMap;
import com.xupt.hamster.core.utils.MailUtils;
import com.xupt.hamster.core.utils.TokenUtils;
import com.xupt.hamster.mapper.StudentMapper;
import com.xupt.hamster.pojo.Student;
import com.xupt.hamster.service.StudentService;
import com.xupt.hamster.vo.StudentLogin;
import com.xupt.hamster.vo.StudentLoginResult;
import com.xupt.hamster.vo.StudentRegist;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private MailUtils mailUtils;

    /**
     * 用户是否存在
     *
     * @param name
     * @param scopeId
     * @return
     */
    public synchronized boolean isExist(String name, Long id, Long scopeId) {
        Long userId = studentMapper.getIdByUserName(name);
        if (null != id && null != userId) {
            return !id.equals(userId);
        }
        return null != userId && userId.longValue() > 0L;
    }

    @Override
    public ResultMap studentLogin(StudentLogin studentLogin) {
        ResultMap resultMap = new ResultMap();
        Student student = studentMapper.selectByUserName(studentLogin.getUsername());
        if (null == student) {
            log.info("user not found: {}", studentLogin.getUsername());
            return resultMap.fail().message("user not found").payload("username or password is wrong");
        }
        StudentLoginResult studentLoginResult = new StudentLoginResult();
        BeanUtils.copyProperties(student, studentLoginResult);
        //校验密码
        if (!BCrypt.checkpw(studentLogin.getPassword(), student.getPassword())) {
            log.info("password is wrong: {}", studentLogin.getUsername());
            return resultMap.fail().message("password is wrong").payload("username or password is wrong");
        }
        return resultMap.success(tokenUtils.generateToken(student)).payload(studentLoginResult);
    }

    /**
     * 用户注册接口
     *
     * @param studentRegist
     * @return
     */
    @Override
    @Transactional
    public ResultMap regist(StudentRegist studentRegist) {
        ResultMap resultMap = new ResultMap(tokenUtils);
        //用户名是否已经注册
        if (isExist(studentRegist.getUsername(), null, null)) {
            log.info("the username {} has been registered", studentRegist.getUsername());
            return resultMap.fail().message("the username:" + studentRegist.getUsername() + " has been registered");
        }
        Student student = new Student();
        //密码加密
        studentRegist.setPassword(BCrypt.hashpw(studentRegist.getPassword(), BCrypt.gensalt()));
        BeanUtils.copyProperties(studentRegist, student);
        //添加用户
        int insert = studentMapper.insert(student);
        if (insert > 0) {
            return resultMap.success(tokenUtils.generateToken(student));
        } else {
            log.info("regist fail: {}", studentRegist.toString());
            return resultMap.fail().message("regist fail: unspecified error");
        }
    }

    /**
     * 根据用户名称获取用户
     * @param username
     * @return
     */
    @Override
    public Student getByUserName(String username) {
        return studentMapper.selectByUserName(username);
    }

    /**
     * 更新用户
     * @param student
     * @param request
     * @return
     */
    @Override
    public ResultMap updateUser(Student student, HttpServletRequest request) {
        return null;
    }

    /**
     * 发送邮件
     * @param email
     * @param student
     * @param request
     * @return
     */
    @Override
    public ResultMap sendMail(String email, Student student, HttpServletRequest request) {
        return null;
    }

    /**
     * 更新用户密码
     * @param student
     * @param oldPassword
     * @param password
     * @param request
     * @return
     */
    @Override
    public ResultMap changeUserPassword(Student student, String oldPassword, String password, HttpServletRequest request) {
        ResultMap resultMap = new ResultMap(tokenUtils);

        //校验原密码
        if (!BCrypt.checkpw(oldPassword, student.getPassword())) {
            return resultMap.failAndRefreshToken(request).message("Incorrect original password");
        }
        //设置新密码
        student.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        student.setUpdateTime(new Date());
        int i = studentMapper.changePassword(student);
        if (i > 0) {
            return resultMap.success().message("Successful password modification");
        } else {
            return resultMap.failAndRefreshToken(request);
        }
    }

}
