package com.cloudbase.service;

import com.cloudbase.vo.Constant;
import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@Component
public class UserServiceFallback implements UserService{

    @Value("${server.port}")
    Integer port;

    @Override
    public ResultVO<UserVO> addUser(UserVO userVO) {
        return new ResultVO<>(Constant.FAIL,"服务访问失败，进入fallback阶段",null,port);
    }
}
