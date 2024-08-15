package com.zhx.cloud;

import java.time.ZonedDateTime;

/**
 * ClassName: Main
 * Package: com.zhx.cloud
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/9 17:23
 * @Version 2.0
 */
public class Main {

        public static void main(String[] args)
        {
            ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
            System.out.println(zbj);
        }
}
