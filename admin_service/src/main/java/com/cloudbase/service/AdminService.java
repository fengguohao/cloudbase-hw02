package com.cloudbase.service;

import com.cloudbase.vo.ResultVO;
import com.cloudbase.vo.UserVO;

/**
 * @author fguohao
 * @date 2021/07/12
 */
public interface AdminService {
    public ResultVO<UserVO> addUser(UserVO userVO);
}
