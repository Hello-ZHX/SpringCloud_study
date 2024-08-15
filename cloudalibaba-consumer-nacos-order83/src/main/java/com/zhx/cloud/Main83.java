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
 * @Create 2024/8/11 18:48
 * @Version 2.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Main83 {
        public static void main(String[] args) {
                SpringApplication.run(Main83.class,args);
            }
}