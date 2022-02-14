package com.lyk.demo.mapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyk.demo.entity.Users;
import com.baomidou.mybatisplus.mapper.BaseMapper;


import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiuYun
 * @since 2022-02-14
 */
public interface UsersMapper extends BaseMapper <Users> {

    //Users selectOne(QueryWrapper<Users> wrapper);
}
