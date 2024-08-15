package com.zhx.cloud.Controller;

import com.zhx.cloud.Service.OrderService;
import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.entities.Order;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/14 23:27
 * @Version 2.0
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public ResultData CreateOrder(@RequestBody Order order){
            orderService.createOrder(order);

            return ResultData.success(order);
    }
}
