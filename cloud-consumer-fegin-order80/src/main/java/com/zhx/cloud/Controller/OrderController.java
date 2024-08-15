package com.zhx.cloud.Controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.Utils.ReturnCodeEnum;
import com.zhx.cloud.apis.PayFeignApi;
import com.zhx.cloud.entities.PayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: OrderController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/7 18:06
 * @Version 2.0
 */
@RestController
@RequestMapping("/openfeign")
public class OrderController {

    @Autowired
    private PayFeignApi payFeignApi;

    @PostMapping("/add")
    public ResultData add(@RequestBody PayDTO payDTO){
        return payFeignApi.add(payDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultData deleteById(@PathVariable("id") int id){
        return payFeignApi.deleteById(id);
    }
    @PutMapping("/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        return payFeignApi.update(payDTO);
    }
    @GetMapping("/getById/{id}")
    public ResultData ggetById(@PathVariable("id") int id){
        try {
            System.out.println("________开始______________"+ DateUtil.now());
            return payFeignApi.getById(id);
        }catch (Exception e){
            System.out.println("________结束______________"+ DateUtil.now());
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public ResultData getAll(){
        return payFeignApi.getAll();
    }

    @GetMapping("/getInfo")
    public String getInfo(){
        return payFeignApi.getInfo();
    }
}
