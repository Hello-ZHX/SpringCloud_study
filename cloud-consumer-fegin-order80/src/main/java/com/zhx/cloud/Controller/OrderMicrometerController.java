package com.zhx.cloud.Controller;

import com.zhx.cloud.apis.PayFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderMicrometerController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 12:21
 * @Version 2.0
 */
@RestController
public class OrderMicrometerController {
    @Autowired
    private  PayFeignApi payFeignApi;

    @GetMapping("/micrometer/getmicrometer/{id}")
    public String getMicrometer(@PathVariable("id") int id){
        return payFeignApi.getMicrometer(id);
    }
}
