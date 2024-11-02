package org.example.utilAndCommonDemo.Response;

import lombok.Getter;

@Getter
public enum ReturnCodeEnum  {



    RC300("300","操作失败"),
    RC200("200","success"),
    RC401("401","2次密码不同"),
    RC402("402","账号或密码长度不同"),
    RC403("403","存在非法字符"),
    RC404("404","账号已存在"),
    RC405("405","注册失败"),
    RC406("406","账号不存在"),
    RC407("407","密码错误"),
    RC408("408","账号不能为空"),
    RC409("409","账号被封"),
    RC410("410","请进行登录"),
    RC411("411","请不要重复登录");


    private final String code;
    /**自定义描述**/
    private final String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    //遍历枚举V1
    public static ReturnCodeEnum getReturnCodeEnum(String code)
    {
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if(element.getCode().equalsIgnoreCase(code))
            {
                return element;
            }
        }
        return null;
    }

}
