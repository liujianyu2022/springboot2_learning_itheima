package com.itheima.mapper;

import com.itheima.dao.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into users values(#{id}, #{userName}, #{password}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertUser1(User user);

    int insertUser2(User user);

    @Delete("delete from users where id = #{id}")
    int deleteById1(@Param("id") Integer id);

    int deleteById2(@Param("id") Integer id);

    @Update("update users set user_name = #{userName} where id = #{id}")
    int updateById1(@Param("userName") String userName, @Param("id") Integer id);
    int updateById2(@Param("userName") String userName, @Param("id") Integer id);

    @Select("select id, user_name as userName, password, age from users")
    List<User> getAllUsers1();
    List<User> getAllUsers2();

    @Select("select id, user_name as userName, password, age from users where id = #{id}")
    User getUserById1(@Param("id") Integer id);
    User getUserById2(@Param("id") Integer id);
}
