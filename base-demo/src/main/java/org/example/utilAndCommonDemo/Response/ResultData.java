package org.example.utilAndCommonDemo.Response;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 通用返回体
 * @param <T>
 */
@Data
public class ResultData<T> {

    private String code;
    private T data;
    private String message;
    private long timestamp;


    public ResultData(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        timestamp = System.currentTimeMillis();
    }

    /**
     * 成功
     * @param code
     * @param data
     * @return
     */
    public static<T> ResultData<T> sucess(String code, T data) {
        String message = ReturnCodeEnum.getReturnCodeEnum(code).getMessage();
        ResultData resultData = new ResultData(code,data,message);
        return resultData;
    }

    /**
     * 失败
     * @param code
     * @param data
     * @return
     * @param <T>
     */
    public static<T> ResultData<T> fail(String code, T data) {
        String message = ReturnCodeEnum.getReturnCodeEnum(code).getMessage();
        ResultData resultData = new ResultData(code,data,message);
        return resultData;
    }


    public static<T> ResultData<T> fail300( T data) {
        String message = ReturnCodeEnum.RC300.getMessage();
        ResultData resultData = new ResultData(ReturnCodeEnum.RC300.getCode(), data,message);
        return resultData;
    }

}
