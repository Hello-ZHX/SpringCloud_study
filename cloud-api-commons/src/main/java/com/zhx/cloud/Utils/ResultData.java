package com.zhx.cloud.Utils;


import lombok.Data;
import lombok.experimental.Accessors;
import lombok.val;

/**
 * ClassName: ResultData
 * Package: Utils
 * Description:
 *
 * @Author 朱恒鑫
 * @Create 2024/8/6 15:53
 * @Version 2.0
 */
@Data
@Accessors(chain = true)
public class ResultData<T>{
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        timestamp=System.currentTimeMillis();
    }

    public static  <T>  ResultData<T> success(T data){
        val resultData = new ResultData<T>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);

        return  resultData;
    }
    public static <T> ResultData<T> fail(String code,String message){
        val resultData = new ResultData<T>();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setData(null);

        return resultData;
    }

}
