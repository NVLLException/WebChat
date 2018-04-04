package com.webchat.service;

import com.webchat.entity.User;
import com.webchat.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    //@Autowired
    private UserMapper userMapper;

    @Transactional
    public User createUser(User user){
        userMapper.createUser(user);
        return userMapper.retrieveUser(user.getId());
    }

    public Boolean validateLoginInfo(String loginName, String password){
        User user = userMapper.retrieveUser(loginName, password);
        if(user != null)
            return true;
        return false;
    }
}
