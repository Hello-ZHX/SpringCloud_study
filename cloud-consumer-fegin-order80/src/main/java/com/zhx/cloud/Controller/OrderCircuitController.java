package com.zhx.cloud.Controller;

import cn.hutool.core.util.IdUtil;
import com.zhx.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2023-11-13 14:54
 * Resilience4j CircuitBreaker 的例子
 */
@RestController
public class OrderCircuitController
{
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id)
    {
        return payFeignApi.getCircuit(id);
    }

    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id,Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }


/*    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service" ,fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
    public String myCBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignApi.getCircuit(id);
    }

    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myBulkheadFallback(Integer id,Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "mybulkheadFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }*/
@GetMapping(value = "/feign/pay/bulkhead/{id}")
@Bulkhead(name = "cloud-payment-service" ,fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.THREADPOOL)
public CompletableFuture<String> myCBulkhead(@PathVariable("id") Integer id)
{
    System.out.println(Thread.currentThread().getName() + "\t" + "开始进入");
     try {
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
    System.out.println(Thread.currentThread().getName() + "\t" + "出去");
     return  CompletableFuture.supplyAsync(()->payFeignApi.getCircuit(id));

}

    //myCircuitFallback就是服务降级后的兜底处理方法
    public CompletableFuture<String> myBulkheadFallback(Integer id,Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return CompletableFuture.supplyAsync(()->"mybulkheadFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }
    @GetMapping(value = "/feign/pay/ratelimiter/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRateLimiterFallback")
    public String myRateLimiter(@PathVariable("id") Integer id)
    {
        return payFeignApi.getCircuit(id);
    }

    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myRateLimiterFallback(Integer id,Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "mybulkheadFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

}