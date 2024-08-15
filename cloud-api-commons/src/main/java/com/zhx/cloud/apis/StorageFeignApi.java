package com.zhx.cloud.apis;

import com.zhx.cloud.Utils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: StorageFeignApi
 * Package: com.zhx.cloud.apis
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/14 23:17
 * @Version 2.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi  {

    @PostMapping(value = "/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
