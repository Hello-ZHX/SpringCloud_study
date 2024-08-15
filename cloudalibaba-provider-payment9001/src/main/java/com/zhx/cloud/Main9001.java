package com.zhx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ${NAME}
 * Package: com.zhx.cloud
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/11 18:42
 * @Version 2.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001 {
      public static void main(String[] args) {
              SpringApplication.run(Main9001.class,args);
          }
}