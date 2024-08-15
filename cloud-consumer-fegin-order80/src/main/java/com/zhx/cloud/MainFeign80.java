package com.zhx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: ${NAME}
 * Package: com.zhx.cloud
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/7 18:01
 * @Version 2.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainFeign80 {
        public static void main(String[] args) {
                SpringApplication.run(MainFeign80.class,args);
            }
}