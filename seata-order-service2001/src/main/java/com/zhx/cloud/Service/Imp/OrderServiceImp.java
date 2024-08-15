package com.zhx.cloud.Service.Imp;

import com.zhx.cloud.Service.OrderService;
import com.zhx.cloud.apis.AccountFeignApi;
import com.zhx.cloud.apis.StorageFeignApi;
import com.zhx.cloud.entities.Order;
import com.zhx.cloud.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.transaction.xa.Xid;
import java.util.List;

/**
 * ClassName: OrderServiceImp
 * Package: com.zhx.cloud.Service.Imp
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/14 23:28
 * @Version 2.0
 */
@Service
@Slf4j
public class OrderServiceImp implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private AccountFeignApi accountFeignApi;


    @Override
    @GlobalTransactional(name = "zhx-create-seata",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //xid检查
        String xid = RootContext.getXID();
        log.info("+++++++++++++++++++++++开始新建订单+++++++++++"+"\t"+"Xid:"+"\t"+xid);
        //设置订单状态为0
        order.setStatus(0);

        //插入订单
        int rows = orderMapper.insertSelective(order);

        //如果插入成功 输入订单获得实体对象
        Order orderForDB = null;
        if(rows > 0){
            orderForDB= orderMapper.selectOne(order);
            log.info("+++++++++++++新建订单成功："+"\t"+orderForDB);
            System.out.println();

            //更新库存
            log.info("__________开始更新库存_________________更新前库存为"+orderForDB.getCount());
            storageFeignApi.decrease(orderForDB.getProductId(),orderForDB.getCount());
            log.info("__________结束更新库存_________________更新后库存为"+orderForDB.getCount());
            System.out.println();
            //更新账户余额
            log.info("__________开始更新账户余额_________________更新前账户余额为"+orderForDB.getMoney());
            accountFeignApi.decrease(orderForDB.getUserId(),orderForDB.getMoney());
            log.info("__________结束更新账户余额_________________更新后账户余额为"+orderForDB.getMoney());
            System.out.println();

            log.info("修改订单状态————————————————————————————");
            orderForDB.setStatus(1);
            Example example = new Example(Order.class);
            Example.Criteria exampleCriteria = example.createCriteria();
            exampleCriteria.andEqualTo("userId",orderForDB.getUserId());
            exampleCriteria.andEqualTo("status",0);

            int updateByExample = orderMapper.updateByExample(orderForDB, example);

            if (updateByExample>0){
                log.info("修改订单完成——————————————————————"+orderForDB);
            }
        }
        log.info("+++++++++++++结束新建订单："+"\t"+"Xid:"+"\t"+xid);


    }
}
