package com.myproject.uservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mytaisname")
public interface UserClient {

    @RequestMapping("/api/findById")
    public  String findByIds(@RequestParam("userId")String id);
}
