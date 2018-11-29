package com.example.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.dao.UserInfoMapper;
import com.example.model.UserInfo;
import com.example.util.MD5Util;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// 这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
		UserInfo info=userInfoMapper.findByName(username);
		return info;
	}
	
	public int adduserInfo(String name,String password) {
		String encodePasswd=MD5Util.encode(password);
		return userInfoMapper.insert(name, encodePasswd);
	}
	
	public UserInfo get(String username) {
		return userInfoMapper.findByName(username);
	}
	
	
    public List<UserInfo> getAll() {
        return userInfoMapper.findAll();
    }

    public int delete(String name) {
        return userInfoMapper.delete(name);
    }

    public int update(String name,String password) {
        return userInfoMapper.update(name, password);
    }
}