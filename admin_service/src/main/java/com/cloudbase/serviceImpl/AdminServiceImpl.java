package com.cloudbase.serviceImpl;

import com.cloudbase.service.AdminService;
import com.cloudbase.service.UserService;
import com.cloudbase.vo.Constant;
import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserService userService;

    @Value("${server.port}")
    Integer port;

    @Override
    public ResultVO<UserVO> addUser(UserVO userVO) {
        if(userVO.getUsername()==null||userVO.getUsername().isEmpty()){
            return new ResultVO<>(Constant.FAIL,"用户名为空，请检查输入",null,port);
        }
        if(userVO.getPassword()==null||userVO.getPassword().isEmpty()){
            return new ResultVO<>(Constant.FAIL,"密码为空，请检查输入",null,port);
        }
        return userService.addUser(userVO);
    }
}
