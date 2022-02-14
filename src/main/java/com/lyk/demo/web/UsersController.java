package com.lyk.demo.web;
import java.io.Console;
import java.io.Serializable;

import com.lyk.demo.entity.Users;
import com.lyk.demo.mapper.UsersMapper;
import com.lyk.demo.utils.Result;
import com.lyk.demo.utils.ResultUtil;
import java.text.SimpleDateFormat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import com.baomidou.mybatisplus.plugins.Page;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liyuke
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/lyk")


public class UsersController {

    @Autowired
    private UsersMapper UsersMapper;
/*
    @RequestMapping(value = "/testurl", method = RequestMethod.POST)
   @ResponseBody
    public String getLoginBySendSms(HttpServletRequest req, HttpServletResponse resp) {

        String re="hello world";
        return re;
    }
*/

    @RequestMapping(value = "/getuserstatus", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserStatus(HttpServletRequest req, HttpServletResponse resp) {
        Result result;
        result = ResultUtil.error(-122, "失败");
        //result = ResultUtil.success("成功1");
        return result;
    }

    //根据ID查询
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserInfo1 (HttpServletRequest req, HttpServletResponse resp) {
        Result result;
        Users user = UsersMapper.selectById(10);
        if (user==null)
        {
            result = ResultUtil.error(-1, "用户不存在");
        }
        else
        {
            result = ResultUtil.success(user);
        }
        return result;
    }

    //根据ID进行批量查询
    @RequestMapping(value = "/selectBatchIds", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserInfo2 (HttpServletRequest req, HttpServletResponse resp) {
        Result result;
        List<Integer> ids = Arrays.asList(1,2);
        List<Users> user = UsersMapper.selectBatchIds(ids);

        if(user.isEmpty())
        {
            result = ResultUtil.error(-2, "用户不存在");
        }
        else
        {
            result = ResultUtil.success(user);
        }
        return result;
    }

/*
    //根据构建的 Wrapper 条件对象，使用 selectOne 查询数据，且只返回一个对象。
    @RequestMapping(value = "/QueryWrapperOne", method = RequestMethod.POST)
    @ResponseBody
    public Users getUserInfo3 (HttpServletRequest req, HttpServletResponse resp) {

        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("ID", 1);
        Users user = UsersMapper.selectOne(wrapper);
        return user;

    }*/

    //分页查询！！！！没有返回！！！
    @RequestMapping(value = "/selectPage", method = RequestMethod.POST)
    @ResponseBody
    public List getUserInfo3 (HttpServletRequest req, HttpServletResponse resp) {
        //创建分页对象（1表示第一页；2表示每页大小为2）
        Page<Map<String,Object>> page = new Page<>(1, 2);
        List<Map<String,Object>> user = page.getRecords();
        return user;
    }

    //insert-----500网络错误
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public int InsertUser (HttpServletRequest req, HttpServletResponse resp) {
        Users user = new Users();
        user.setId("5");
        user.setUsername("zhou");
        user.setPassword("12345");
        user.setTelephone("13811111111");
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        dateFormat.format(date);
        user.setSubmissionDate(date);
        int result = UsersMapper.insert(user);
        return result;
    }

}
