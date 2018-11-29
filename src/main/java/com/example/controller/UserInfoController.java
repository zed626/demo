package com.example.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.MyUserDetailsService;
import com.example.model.UserInfo;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping("insert")
    public String insert(@Param("name") String name, @Param("password") String password) {
        if(myUserDetailsService.adduserInfo(name, password)==1) {
        	return "新增成功";
        }
        return "失败";
    }

    @GetMapping("delete")
    public int delete(@Param("name") String name) {
        return myUserDetailsService.delete(name);
    }
    
    
    @GetMapping("get/{name}")
    public UserInfo getUser(@PathVariable("name") String name) {
        return myUserDetailsService.get(name);
    }
    
    @GetMapping("getAll")
    public List<UserInfo> getAll(){
        return myUserDetailsService.getAll();
    }


    @GetMapping("update")
    public int update(@Param("name") String name) {
        return myUserDetailsService.delete(name);
    }
}