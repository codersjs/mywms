package org.example.utilAndCommonDemo.Exception;



import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GloabExceptionHandle {

    @ExceptionHandler(BusinessException.class)
    public ResultData businessExceptionHandler(BusinessException e) {
        return ResultData.fail(e.getCode(),e.getMessage());
    }

}
