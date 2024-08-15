package com.zhx.cloud.Controller;


import com.zhx.cloud.Service.PayService;
import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.Utils.ReturnCodeEnum;
import com.zhx.cloud.entities.Pay;
import com.zhx.cloud.entities.PayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: PayController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/5 17:57
 * @Version 2.0
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付crud")
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;


    @PostMapping("/add")
    @Operation(summary = "新增",description = "新增支付流水，json串作参数")
    public ResultData<String> Add(@RequestBody Pay pay){
        val rows = payService.Add(pay);
//        return "添加成功，共"+rows+"条记录";
        if(rows>0){

            return ResultData.success("添加成功，共"+rows+"条记录");
        }else {
            return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
        }
    }

    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<String> DeleteById(@PathVariable("id") int id){
        val rows = payService.Delete(id);
//        return "删除成功，共"+rows+"条记录";

        if(rows>0){
            return ResultData.success("删除成功，共"+rows+"条记录");
        }else {
            return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
        }
    }


    @PutMapping("/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> Update(@RequestBody PayDTO payDTO){
        val pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        val rows = payService.Update(pay);
//        return "更新成功，共"+rows+"条记录";

        if(rows>0){
            return ResultData.success("更新成功，共"+rows+"条记录");
        }else {
            return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") int id){


        if(id < 0) throw new RuntimeException("id不能为负数");


//        return payService.SelectById(id);
       Pay pay = payService.SelectById(id);
        if(pay==null){
            return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
        }
        return ResultData.success(pay);
    }

    @GetMapping("/getAll")
    @Operation(summary = "查询所有流水",description = "查询所有支付流水方法")
    public ResultData<List<Pay>> getAll(){

        val payList = payService.SelectAll();

//        return payList;
        if(payList==null){
            return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
        }
        return ResultData.success(payList);

    }
    @GetMapping("/error")
    public ResultData<Integer> getError(){
        val integer = Integer.valueOf(200);
        try {
            System.out.println("come in here_____________");
            int data=10/0;
        }catch (Exception e){
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return  ResultData.success(integer);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping("/getInfo")
    public String getInfo(@Value("${zhx.info}") String info){
        return "zhxConfig"+"\t"+info+"\t"+"port:"+port;
    }
}
