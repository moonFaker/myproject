package com.mybatis.controller;

import com.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestConstroller {

    @Value("${server.port}")
    private int port;
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/findById")
    public  Object findById(@RequestParam("userId") String userId){
        Map data=new HashMap();
        data.put("port",port);
        data.put("data",userMapper.getById(userId));
        return  data;
    }

    @RequestMapping("/updateById")
    public  Object updateById(@RequestParam("userId") String userId,@RequestParam("name") String name){
        return  userMapper.updateById(userId,name);
    }
}
