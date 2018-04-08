package com.webchat.service;

import com.webchat.entity.User;
import com.webchat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User createUser(User user){
        userMapper.createUser(user);
        return userMapper.retrieveUserById(user.getId());
    }

    public Boolean validateLoginInfo(String loginName, String password){
        User user = userMapper.retrieveUserByNameAndPwd(loginName, password);
        if(user != null)
            return true;
        return false;
    }

    public User retrieveUser(String loginName, String password){
        return userMapper.retrieveUserByNameAndPwd(loginName, password);
    }

    public Boolean validateLoginName(String loginName){
        User user = userMapper.retrieveUserByLoginName(loginName);
        if(user != null){
            return true;
        }
        return false;
    }
}
