package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.model.UserInfo;

public interface UserInfoMapper {

    @Select("select * from user_info where username = #{username}")
    UserInfo findByName(@Param("username") String username);
    
    @Select("select * from user_info")
    List<UserInfo> findAll();

    @Insert("insert into user_info ( username ,password,role,accountNonExpired,accountNonLocked,credentialsNonExpired,enabled) values (#{username},#{password},'ROLE_ADMIN',true,true,true,true)")
    int insert(@Param("username") String username, @Param("password") String password);

    @Delete("delete from user_info where username = #{username}")
    int delete(@Param("username") String username);

    @Update("update user_info set password = #{password} where username = #{username}")
    int update(@Param("username") String username, @Param("password") String password);
}
