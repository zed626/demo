package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserMapper;
import com.example.model.User;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> get(String name) {
        return userMapper.findByName(name);
    }
    
    public List<User> getAll() {
        return userMapper.findAll();
    }

    public int insert(String name, Integer age) {
        return userMapper.insert(name, age);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    public int update(Integer id, Integer age) {
        return userMapper.update(id, age);
    }

}
