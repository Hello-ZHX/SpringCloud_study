package com.zhx.cloud.Service;

import com.zhx.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName: PayService
 * Package: com.zhx.cloud.Service
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/5 17:50
 * @Version 2.0
 */
public interface PayService {
     int Add(Pay pay);
     int Delete(int id);
     int Update(Pay pay);
     Pay SelectById(int id);
     List<Pay> SelectAll();

}
