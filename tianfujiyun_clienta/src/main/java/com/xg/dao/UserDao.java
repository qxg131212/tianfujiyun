package com.xg.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserDao  extends  BaseMapper<User>{
}
