package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MusicDashBoard9000 {
    public static void main(String[] args) {
        SpringApplication.run(MusicDashBoard9000.class, args);
    }
}
