package com.nhnacademy.shoppingmall.service;

import com.nhnacademy.shoppingmall.entity.User;
import com.nhnacademy.shoppingmall.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public User modifyUser(User user){
        return userRepository.save(user);
    }
}
