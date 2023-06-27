package org.joker.userservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.joker.userservice.pojo.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{userId}")
    User selectUserById(int userId);
}
