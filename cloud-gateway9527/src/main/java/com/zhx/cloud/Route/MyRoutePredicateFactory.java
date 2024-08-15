package com.zhx.cloud.Route;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: MyRoutePredicateFactory
 * Package: com.zhx.cloud.Route
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 18:19
 * @Version 2.0
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory()
    {
        super(MyRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("user");
    }


    @Validated
    public static class Config{
        @Setter
        @Getter
        @NotEmpty
        private String user;
    }
    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                val user = serverWebExchange.getRequest().getQueryParams().getFirst("user");
                if(user==null){
                    return false;
                }
                if(user.equals(config.getUser())){
                    return true;
                }
                return false;
            }
        };
    }
}
