package com.myproject.uservice.constroller;

import com.myproject.uservice.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserClient userClient;

    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/findById")
    @HystrixCommand(fallbackMethod = "fallBack")
    public  Object findById(@RequestParam("userId")String userId,@RequestParam("testId")String testId){

        System.out.println("进入7");
        return    restTemplate.getForObject("http://mybatis/api/v1/findById="+userId,Object.class);
        //return  userClient.findByIds(userId);
    }

    private Object fallBack(String userId,String aa){
        System.out.println("userID:"+userId+"  testId:"+aa);
        return  null;
    }
}
