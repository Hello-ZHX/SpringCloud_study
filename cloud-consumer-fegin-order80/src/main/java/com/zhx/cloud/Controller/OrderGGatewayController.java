package com.zhx.cloud.Controller;

import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderGGatewayController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 15:23
 * @Version 2.0
 */
@RestController
@RequestMapping("/gateway")
public class OrderGGatewayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/getById/{id}")
    public ResultData getById(@PathVariable("id") int id){
        return payFeignApi.GategetById(id);
    }

    @GetMapping("/getInfo")
    public ResultData getInfo(){
        return payFeignApi.gatewayTest();
    }
}
