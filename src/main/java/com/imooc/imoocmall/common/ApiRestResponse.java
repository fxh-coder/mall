package com.imooc.imoocmall.common;

import com.imooc.imoocmall.exception.ImoocMallExceptionEnum;

/**
 * 描述：  通用返回对象
 */
public class ApiRestResponse<T> {
    private Integer status;
    private String msg;
    private T data;
    private static final int OK_CODE = 10000;
    private static final String OK_MSG = "SUCCESS";

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiRestResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    // 无参构造函数，不需要传递任何信息使用默认信息
    public ApiRestResponse() {
        this(OK_CODE, OK_MSG);
    }

    // 返回返回构造函数的信息也就是返回默认方法
    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }

    // 返回数据成功的方法
    public static <T> ApiRestResponse<T> success(T result) {
        ApiRestResponse<T> response = new ApiRestResponse<>();
        response.setData(result);
        return response;
    }

    // 返回数据失败的方法
    public static <T> ApiRestResponse<T> error(Integer code, String msg) {
        return new ApiRestResponse<>(code, msg);
    }

    // 返回数据失败的方法
    public static <T> ApiRestResponse<T> error(ImoocMallExceptionEnum ex) {
        return new ApiRestResponse<>(ex.getCode(), ex.getMsg());
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
