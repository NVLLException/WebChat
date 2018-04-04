package com.webchat.mapper;


import com.webchat.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper {
    @Insert("insert into user(loginName,nickName,password,createTime,lastModifyTime)values(#{loginName},#{nickName},#{password},now(),now())")
    public void createUser(User user);

    @Select("select loginName,nickName from user where id=#{id}")
    public User retrieveUser(@Param("id") Integer id);

    @Update("update user set password=#{newPassword} and id=${id} and password=#{password}")
    public void updatePassword(@Param("id") Integer id, @Param("password") String password, @Param("newPassword") String newPassword);

    @Update("update user set nikeName=#{nikeName} where id=#{id}")
    public void updateNikeName(@Param("nickName") String nickName, @Param("id") Integer id);
}
