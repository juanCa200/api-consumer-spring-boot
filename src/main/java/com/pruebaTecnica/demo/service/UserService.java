package com.pruebaTecnica.demo.service;

import com.pruebaTecnica.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;
    private final String apiUrl = "https://jsonplaceholder.typicode.com/users";

    @Cacheable("users")
    public List<User> getUsers() {
        User[] usersArray = restTemplate.getForObject(apiUrl, User[].class);
        return Arrays.asList(usersArray);
    }
}
