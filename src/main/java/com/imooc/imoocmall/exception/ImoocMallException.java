package com.imooc.imoocmall.exception;

/**
 * 统一异常
 */
public class ImoocMallException extends RuntimeException {
    private final Integer code;
    private final String message;

    public ImoocMallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ImoocMallException(ImoocMallExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ImoocMallException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
