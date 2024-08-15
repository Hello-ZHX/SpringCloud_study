package com.zhx.cloud.Config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MyRetryerConfig
 * Package: com.zhx.cloud.Config
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/7 19:15
 * @Version 2.0
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Retryer myRetryer(){
//        return new Retryer.Default(100,1,3);
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
