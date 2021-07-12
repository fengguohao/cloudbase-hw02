package com.cloudbase.controller;

import com.cloudbase.service.UserService;
import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResultVO<UserVO> addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    }

    @GetMapping("/disable")
    public ResultVO<Object> disable(){
        return userService.disable();
    }

    @GetMapping("/enable")
    public ResultVO<Object> enable(){
        return userService.enable();
    }
}
