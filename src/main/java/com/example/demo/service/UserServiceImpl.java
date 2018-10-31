package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Arthur
 * @date 2018-10-25
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setName("User" + id);
        user.setPwd(id+"");
        return user;
    }

}
