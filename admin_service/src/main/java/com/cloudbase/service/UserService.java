package com.cloudbase.service;

import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@FeignClient(name = "user-service",fallback = UserServiceFallback.class)
public interface UserService {
    @PostMapping("/user/add")
    public ResultVO<UserVO> addUser(@RequestBody UserVO userVO);
}
