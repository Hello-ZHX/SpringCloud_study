package com.zhx.cloud.Controller;

import com.zhx.cloud.Service.StorageService;
import com.zhx.cloud.Utils.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: StorageController
 * Package: com.zhx.cloud.Controller
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/15 0:02
 * @Version 2.0
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
