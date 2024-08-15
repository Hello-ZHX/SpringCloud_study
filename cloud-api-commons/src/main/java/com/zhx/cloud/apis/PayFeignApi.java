package com.zhx.cloud.apis;

import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.entities.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: PayFeignApi
 * Package: com.zhx.cloud.apis
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/7 18:08
 * @Version 2.0
 */
//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData add(@RequestBody PayDTO payDTO);

    @DeleteMapping("/pay/deleteById/{id}")
    ResultData deleteById(@PathVariable("id") int id);

    @PutMapping("/pay/update")
    ResultData update(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/getById/{id}")
    ResultData getById(@PathVariable("id") int id);

    @GetMapping("/pay/getAll")
    ResultData getAll();

    @GetMapping("/pay/getInfo")
    String getInfo();

    @GetMapping(value = "/pay/circuit/{id}")
    String getCircuit(@PathVariable("id") int id);

    @GetMapping(value = "/pay/ratelimit/{id}")
    String getRateLimit(@PathVariable("id") int id);

    @GetMapping("/pay/micrometer/{id}")
    String getMicrometer(@PathVariable("id") int id);

    @GetMapping("/pay/gateway/{id}")
     ResultData GategetById(@PathVariable("id") int id);

    @GetMapping("/pay/gatewayInfo")
    ResultData<String> gatewayTest();
}
