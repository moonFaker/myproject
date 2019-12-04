package com.myproject.uservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class UserServiceStarter {
    public static void main(String[] args) {

        SpringApplication.run(UserServiceStarter.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate(){
       return new RestTemplate();
    }
}
