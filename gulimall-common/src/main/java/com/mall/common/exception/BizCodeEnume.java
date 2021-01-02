package com.mall.common.exception;

/**
 * 错误码统一
 */
public enum BizCodeEnume {

    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    VAILD_EXCEPTION(10001, "参数格式校验失败");

    private String message;
    private Integer code;

    BizCodeEnume(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}
