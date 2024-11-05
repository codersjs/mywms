package org.example.utilAndCommonDemo.Enum;


public enum EnumReceiptTask {
    RECNewOrder("N","新订单"),
    RECOngoing("O","订单进行中"),
    RECFinish("F","订单完成"),
    INSAwait("W","待检验"),
    INSOngoing("O","检验中"),
    INSFinish("F","检验完成"),
    INSisNULL("Notyet","暂时没有"),
    INSNotStart("W","没有开始")
    ;

    private String code;
    private String message;
    private EnumReceiptTask(String code, String message) {
        this.code = code;
        this.message = message;
    }


    //遍历枚举V1
    public static EnumReceiptTask getReturnCodeEnum(String code)
    {
        for (EnumReceiptTask receiptEnum : EnumReceiptTask.values()) {
            if (receiptEnum.code.equals(code)) {
                return receiptEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

}
