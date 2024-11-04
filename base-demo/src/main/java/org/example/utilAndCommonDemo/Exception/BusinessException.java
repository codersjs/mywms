package org.example.utilAndCommonDemo.Exception;

/**
 * 自定义异常
 */
public class BusinessException extends RuntimeException{

    private String code;


    public BusinessException(String message) {
        super(message);
        this.code = "414";
    }

    public String getCode() {
        return code;
    }

}
