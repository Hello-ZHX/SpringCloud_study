package com.zhx.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyRequestOriginParser
 * Package: com.zhx.cloud.handler
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/12 19:55
 * @Version 2.0
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("username");
    }
}
