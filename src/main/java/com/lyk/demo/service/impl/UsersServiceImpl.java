package com.lyk.demo.service.impl;

import com.lyk.demo.entity.Users;
import com.lyk.demo.mapper.UsersMapper;
import com.lyk.demo.service.IUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiuYun
 * @since 2022-02-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
