package com.zhx.cloud;

import tk.mybatis.spring.annotation.MapperScan;
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
 * @Create 2024/8/14 23:57
 * @Version 2.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@MapperScan("com.zhx.cloud.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class Main2002 {
        public static void main(String[] args) {
                SpringApplication.run(Main2002.class,args);
            }

}