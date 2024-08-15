package com.zhx.cloud.Service.imp;

import com.zhx.cloud.Service.PayService;
import com.zhx.cloud.entities.Pay;
import com.zhx.cloud.mapper.PayMapper;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: PayServiceImp
 * Package: com.zhx.cloud.Service.imp
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/5 17:52
 * @Version 2.0
 */
@Service
public class PayServiceImp implements PayService {
    @Resource
    private PayMapper payMapper;


    @Override
    public int Add(Pay pay) {
        val row = payMapper.insertSelective(pay);
        return row;
    }

    @Override
    public int Delete(int id) {
        val rows = payMapper.deleteByPrimaryKey(id);
        return rows;
    }

    @Override
    public int Update(Pay pay) {
        val rows = payMapper.updateByPrimaryKeySelective(pay);
        return rows;
    }

    @Override
    public Pay SelectById(int id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> SelectAll() {
        return payMapper.selectAll();
    }
}
