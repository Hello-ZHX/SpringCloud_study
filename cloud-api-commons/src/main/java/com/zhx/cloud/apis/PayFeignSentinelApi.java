package com.zhx.cloud.apis;

import com.zhx.cloud.Utils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PayFeignSentinelApi
 * Package: com.zhx.cloud.apis
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/13 0:04
 * @Version 2.0
 */
@FeignClient(name = "nacos-payment-provider",fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
