package com.cloudbase.controller;

import com.cloudbase.service.AdminService;
import com.cloudbase.service.UserService;
import com.cloudbase.vo.Constant;
import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    public ResultVO<UserVO> addUser(@RequestBody UserVO userVO){
        return adminService.addUser(userVO);
    }
}
