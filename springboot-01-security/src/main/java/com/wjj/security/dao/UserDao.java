package com.wjj.security.dao;

import com.wjj.security.pojo.UserEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wjj
 * @create 2021/11/30
 * @Description
 */

public interface UserDao extends JpaRepository<UserEntity,Long> {
    UserEntity findUserEntitiesByUsername(String userName);

}
