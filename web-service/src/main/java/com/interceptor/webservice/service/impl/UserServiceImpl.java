package com.interceptor.webservice.service.impl;

import com.interceptor.webservice.model.User;
import com.interceptor.webservice.repository.UserRepository;
import com.interceptor.webservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    @Transactional
    public void setActiveStatus(Long id, Boolean status) {
        userRepository.findById(id).ifPresent(user -> user.setActive(status));
    }
}
