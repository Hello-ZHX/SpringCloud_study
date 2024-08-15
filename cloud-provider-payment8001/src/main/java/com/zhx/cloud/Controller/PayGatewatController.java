package com.zhx.cloud.Controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.zhx.cloud.Service.PayService;
import com.zhx.cloud.Utils.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

/**
 * ClassName: PayGatewatController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 15:08
 * @Version 2.0
 */
@RestController
@RequestMapping("/pay")
public class PayGatewatController{
    @Resource
    private PayService payService;

    @GetMapping("/gateway/{id}")
    public ResultData GategetById(@PathVariable("id") int id){
        return ResultData.success(payService.SelectById(id));
    }

    @GetMapping("/gatewayInfo")
    public ResultData<String> gatewayTest(){
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }

    @GetMapping("/gateway/filter")
    public ResultData getGatewayFilter(HttpServletRequest request) {
        String result = "";
        val headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            val headName = headers.nextElement();
            val headerValue = request.getHeader(headName);
            System.out.println("请求头名：" + headName + "," + "\t" + "请求头值：" + headerValue);
            if (headName.equalsIgnoreCase("X-request-zhx") || headName.equalsIgnoreCase("X-request-zyf")) {
                result = result + headName + "\t" + headerValue + "  ";
            }
        }

        System.out.println("=============================================");
        String userId = request.getParameter("userId");
        System.out.println("request Parameter userId: "+userId);

        String userName = request.getParameter("username");
        System.out.println("request Parameter userName: "+userName);
        System.out.println("=============================================");
        return ResultData.success("getGateWayFilter 过滤器 test:{" + result + "}" + "\t" + DateUtil.now());
    }
}
