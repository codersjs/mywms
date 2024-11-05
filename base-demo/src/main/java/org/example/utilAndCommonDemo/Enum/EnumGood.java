package org.example.utilAndCommonDemo.Enum;

public enum EnumGood {

    Weight("W","称重的物品"),
    Number("NUM","单个计算个数"),
    Heap("H","堆区")
    ;

    private String code;
    private String message;
    private EnumGood(String code, String message) {
        this.code = code;
        this.message = message;
    }


    //遍历枚举V1
    public static EnumGood getReturnCodeEnum(String code)
    {
        for (EnumGood good : EnumGood.values()) {
            if (good.code.equals(code)) {
                return good;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }
}
