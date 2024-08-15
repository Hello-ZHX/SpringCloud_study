package com.zhx.cloud.Service.Imp;

import com.zhx.cloud.Service.StorageService;
import com.zhx.cloud.mapper.StorageMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ClassName: StorageServiceImp
 * Package: com.zhx.cloud.Service
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/15 0:05
 * @Version 2.0
 */
@Service
public class StorageServiceImp implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        storageMapper.decrease(productId,count);
        System.out.println("**********************************************"+count);
    }
}
