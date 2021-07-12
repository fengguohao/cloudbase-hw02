package com.cloudbase.dao;

import com.cloudbase.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author fguohao
 * @date 2021/07/12
 */
public interface UserDao extends CrudRepository<UserEntity,Integer> {
}
