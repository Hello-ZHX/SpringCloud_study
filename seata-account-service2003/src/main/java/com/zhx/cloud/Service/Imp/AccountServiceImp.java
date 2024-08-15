package com.zhx.cloud.Service.Imp;

import com.zhx.cloud.Service.AccountService;
import com.zhx.cloud.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: AccountServiceImp
 * Package: com.zhx.cloud.Service.Imp
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/15 0:15
 * @Version 2.0
 */
@Service
public class AccountServiceImp implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        accountMapper.decrease(userId,money);
        myTimeOut();
//        int i=10/0;
    }

    private void myTimeOut() {
            try {
                    TimeUnit.SECONDS.sleep(65);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
    }
}
