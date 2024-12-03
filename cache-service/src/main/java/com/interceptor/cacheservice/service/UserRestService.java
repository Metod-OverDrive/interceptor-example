package com.interceptor.cacheservice.service;

import com.interceptor.cacheservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRestService {

    @Value("${servers-url.web-service}")
    private String webServiceUrl;
    private final RestTemplate restTemplate;

    public List<User> getAllUsers() {
        String url = webServiceUrl + "users/all";
        var result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );

        return result.getBody();
    }

    @Cacheable(value = "userById", key = "#id")
    public User getUserById(Long id) {
        String url = webServiceUrl + "users?id=" + id;
        User user =  restTemplate.getForObject(url, User.class);
        return user;
    }

    @Cacheable(value = "userByUsername", key = "#username")
    public User getUserByUsername(String username) {
        String url = webServiceUrl + "users?username=" + username;
        return restTemplate.getForObject(url, User.class);
    }

    @CachePut(value = "userById", key = "#id")
    public User getActualUserById(Long id) {
        String url = webServiceUrl + "users?id=" + id;
        return restTemplate.getForObject(url, User.class);
    }

    @CachePut(value = "userByUsername", key = "#username")
    public User getActualUserByUsername(String username) {
        String url = webServiceUrl + "users?username=" + username;
        return restTemplate.getForObject(url, User.class);
    }
}
