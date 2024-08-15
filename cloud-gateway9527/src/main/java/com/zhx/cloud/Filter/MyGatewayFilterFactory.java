package com.zhx.cloud.Filter;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyGatewayFilterFactory
 * Package: com.zhx.cloud.Filter
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/10 0:30
 * @Version 2.0
 */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    public MyGatewayFilterFactory(){
        super(MyGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(MyGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                var request=exchange.getRequest();
                System.out.println("进入自定义网关过滤器MyGatewayFilter，status==="+config.getStatus());
                if (request.getQueryParams().containsKey("zhx")){
                    return chain.filter(exchange);
                }
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);

                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        val list = new ArrayList<String>();
        list.add("status");
        return list;
    }

    public static  class  Config{
        @Getter
        @Setter
        private String status;
    }
}
