package com.zhx.cloud.Controller;

import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName: ConsumerController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/6 18:05
 * @Version 2.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
//    public static final String PaymentSrc_URL="http://localhost:8001";
    public static final String PaymentSrc_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResultData add(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrc_URL+"/pay/add",payDTO,ResultData.class);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultData deleteById(@PathVariable int id){
//        return restTemplate.getForObject(PaymentSrc_URL+"/pay/deleteById/"+id,ResultData.class,id);

        restTemplate.delete(PaymentSrc_URL+"/pay/deleteById/"+id,id);
        return ResultData.success("成功过删除！！");
    }
    @PutMapping("/update")
    public ResultData update(@RequestBody PayDTO payDTO){
//        return restTemplate.postForObject(PaymentSrc_URL+"/pay/update",payDTO,ResultData.class);

        restTemplate.put(PaymentSrc_URL+"/pay/update",payDTO);
        return ResultData.success("成功更新！！！");
    }
    @GetMapping("/getById/{id}")
    public ResultData getById(@PathVariable int id){
        return restTemplate.getForObject(PaymentSrc_URL+"/pay/getById/"+id,ResultData.class,id);
    }

    @GetMapping("/getAll")
    public ResultData getAll(){
        return restTemplate.getForObject(PaymentSrc_URL+"/pay/getAll",ResultData.class);
    }

    @GetMapping("/getInfo")
    public String getInfo(){
        return restTemplate.getForObject(PaymentSrc_URL+ "/pay/getInfo", String.class);
    }


    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
