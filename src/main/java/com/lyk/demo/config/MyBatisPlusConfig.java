package com.lyk.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;


@Configuration
@MapperScan("com.lyk.demo.mapper")
public class MyBatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    //@Bean
    //public PaginationInterceptor paginationInterceptor() {
        //return new PaginationInterceptor();
    //}
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        return page;
    }

}
