package org.example.utilAndCommonDemo.Enum;

public enum EnumInbound {
    NEW("N","新订单"),
    NEEDGET("G","去货中"),
    NEEDPUT("P","放货中"),
    FINSH("F","完成");

    private String code;
    private String message;


    private EnumInbound(String code, String message) {
        this.code = code;
        this.message = message;
    }


    //遍历枚举V1
    public static EnumInbound getReturnCodeEnum(String code)
    {
        for (EnumInbound item : EnumInbound.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }
}
