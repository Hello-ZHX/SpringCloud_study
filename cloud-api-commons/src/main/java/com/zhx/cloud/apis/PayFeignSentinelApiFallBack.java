package com.zhx.cloud.apis;

import com.zhx.cloud.Utils.ResultData;
import com.zhx.cloud.Utils.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * ClassName: PayFeignSentinelApiFallBack
 * Package: com.zhx.cloud.apis
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/13 0:06
 * @Version 2.0
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
