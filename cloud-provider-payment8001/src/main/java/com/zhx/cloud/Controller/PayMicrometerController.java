package com.zhx.cloud.Controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: PayMicrometerController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 12:17
 * @Version 2.0
 */
@RestController
public class PayMicrometerController {
    @GetMapping("/pay/micrometer/{id}")
    public String getMicrometer(@PathVariable("id") int id){
        return "Hello, 欢迎到来myMicrometer inputId:  "+id+" \t    服务返回:" + IdUtil.simpleUUID();
    }
}
