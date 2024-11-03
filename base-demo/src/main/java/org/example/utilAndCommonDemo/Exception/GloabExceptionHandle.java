package org.example.utilAndCommonDemo.Exception;



import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GloabExceptionHandle {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultData businessExceptionHandler(BusinessException e) {
        return new ResultData<>(e.getCode(), null,e.getMessage());
    }

}
