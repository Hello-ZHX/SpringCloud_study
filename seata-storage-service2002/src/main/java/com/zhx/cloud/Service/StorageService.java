package com.zhx.cloud.Service;

/**
 * ClassName: StroageService
 * Package: com.zhx.cloud.Controller.Service
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/15 0:02
 * @Version 2.0
 */

public interface StorageService {
    void decrease(Long productId, Integer count);
}
