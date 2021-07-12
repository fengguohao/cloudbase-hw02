package com.cloudbase.serviceImpl;

import com.cloudbase.dao.UserDao;
import com.cloudbase.entity.UserEntity;
import com.cloudbase.service.UserService;
import com.cloudbase.vo.Constant;
import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fguohao
 * @date 2021/07/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${server.port}")
    Integer port;

    @Autowired
    UserDao userDao;

    boolean disabled = false;

    @Override
    public ResultVO<UserVO> addUser(UserVO userVO)  {
        if(disabled){
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userVO.getUsername());
        userEntity.setPassword(userVO.getPassword());
        UserEntity userEntity1 = userDao.save(userEntity);
        if(userEntity1!=null){
            UserVO userVO1 = new UserVO();
            BeanUtils.copyProperties(userEntity1,userVO1);
            return new ResultVO<>(Constant.SUCCESS,"创建用户成功",userVO1,port);
        }
        return new ResultVO<>(Constant.FAIL,"创建用户失败",null,port);
    }

    @Override
    public ResultVO<Object> disable() {
        this.disabled = true;
        return new ResultVO<>(Constant.SUCCESS,"disabled",null,port);
    }

    @Override
    public ResultVO<Object> enable() {
        this.disabled = false;
        return new ResultVO<>(Constant.SUCCESS,"enabled",null,port);
    }
}
