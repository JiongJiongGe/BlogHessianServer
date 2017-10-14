package com.mybatis.controller;

import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试 用户
 *
 * Created by yunkai on 2017/5/24.
 */
@RestController
@RequestMapping("test")
public class TestUserController {

    private static final Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    /**
     * 测试请求链接是否成功
     *
     * @return
     */
    @GetMapping(value = "getTest")
    public String getTest() {
        return "wjd  is  good";
    }

    /**
     * 测试获取所有用户数据
     *
     * @return
     */
    @GetMapping(value = "testService")
    public List<CalmWangUserModel> testService() {
        List<CalmWangUserModel> users = calmWangUserService.findUserList();
        return users;
    }

    /**
     * 测试获取所有用户数据  POST方法
     * @param name
     * @param phone
     * @return
     */
    @PostMapping(value = "userListJson")
    public List<CalmWangUserModel> userListJson(String name, String phone) {
        List<CalmWangUserModel> users = calmWangUserService.findUserList();
        return users;
    }

    /**
     * 根据用户姓名获取用户信息
     *
     * @param name
     * @return
     */
    @GetMapping(value = "getByName")
    public List<CalmWangUserModel>  getByName(String name) {
        List<CalmWangUserModel> users = calmWangUserService.getByName(name);
        return users;
    }

    /**
     * 保存用户信息
     *
     * @param userName  用户姓名
     * @param userPhone  用户联系方式
     * @return
     */
    @GetMapping(value = "saveUserJson")
    public Integer saveUserJson(String userName, String userPhone) {
        Integer userID = calmWangUserService.saveUser(userName, userPhone);
        return userID;
    }

    /**
     * 通过手机号获取用户
     *
     * @param phone
     * @return
     */
    @GetMapping(value = "findUserByPhone")
    public String findUserByPhone(String phone){
        Long allTime = (long) 0;
        for(int j=0; j<9; j++) {
            Long startTime = System.currentTimeMillis();
            for (int i = 0; i < 9; i++) {
                List<CalmWangUserModel> users = calmWangUserService.findUserByPhone(phone);
            }
            Long endTime = System.currentTimeMillis();
            allTime += (endTime-startTime);
        }
//        List<CalmWangUserModel> users = calmWangUserService.findUserByPhone(phone);
        logger.info("总时间======" + allTime);
        return "success";
    }
}
