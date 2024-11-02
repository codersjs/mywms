package org.example.utilAndCommonDemo.Exception;

/**
 * 自定义异常
 */
public class BusinessException extends RuntimeException{

    private String code;
    private String message;


    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

}
