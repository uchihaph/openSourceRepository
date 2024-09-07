package com.open.source.platform;

public enum ResponseCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    Integer code;
    String desc;

    ResponseCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
