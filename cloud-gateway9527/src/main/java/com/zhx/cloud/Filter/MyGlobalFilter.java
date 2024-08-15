package com.zhx.cloud.Filter;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: MyGlobalFilter
 * Package: com.zhx.cloud.Filter
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/10 0:09
 * @Version 2.0
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private static  final  String BEGAIN_VIST_TIME="BEGGIN_VIST_TIME";
    private static final Logger log = LoggerFactory.getLogger(MyGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //先记录下访问接口的开始时间
        exchange.getAttributes().put(BEGAIN_VIST_TIME,System.currentTimeMillis());

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long beginVisitTime = exchange.getAttribute(BEGAIN_VIST_TIME);
            if(beginVisitTime !=null){
                log.info("访问主机"+exchange.getRequest().getURI().getHost());
                log.info("访问接口端口"+exchange.getRequest().getURI().getPort());
                log.info("访问接口的URI"+exchange.getRequest().getURI().getPath());
                log.info("访问接口的参数"+exchange.getRequest().getURI().getRawQuery());
                log.info("访问时长"+(System.currentTimeMillis()-beginVisitTime)+"ms");
                log.info("分割线===========================================================");
                System.out.println();
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
