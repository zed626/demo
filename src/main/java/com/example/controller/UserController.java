package com.example.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get/{name}")
    public List<User> getUser(@PathVariable("name") String name) {
        return userService.get(name);
    }
    
    @GetMapping("getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("insert")
    public String insert(@Param("name") String name, @Param("age") Integer age) {
        if(userService.insert(name, age)==1) {
        	return "新增成功";
        }
        return "失败";
    }

    @GetMapping("delete")
    public int delete(@Param("id") Integer id) {
        return userService.delete(id);
    }

    @GetMapping("update")
    public int update(@Param("id") Integer id, @Param("age") Integer age) {
        return userService.update(id, age);
    }

}