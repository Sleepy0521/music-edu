package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.music"})
//@ComponentScan("com.tencent.mpm")
public class MusicConsumer8300 {
    public static void main(String[] args) {
        SpringApplication.run(MusicConsumer8300.class, args);
    }
}
