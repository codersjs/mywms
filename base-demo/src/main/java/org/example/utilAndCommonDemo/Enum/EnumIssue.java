package org.example.utilAndCommonDemo.Enum;

public enum EnumIssue {
    Finish("F","可发货了"),
    WaitChe("W","等待验收和包装"),
    Pick("P","拣货中"),
    New("N","新订单")
    ;


    private EnumIssue(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public EnumIssue getByCode(String code) {
        for (EnumIssue enumIssue : EnumIssue.values()) {
            if (enumIssue.getCode().equals(code)) {
                return enumIssue;
            }
        }
        return null;
    }

}
