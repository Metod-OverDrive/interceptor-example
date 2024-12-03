package com.interceptor.webservice.service;

import com.interceptor.webservice.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getById(Long id);

    User getByUsername(String username);

    void setActiveStatus(Long id, Boolean status);
}
