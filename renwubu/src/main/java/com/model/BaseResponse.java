package com.model;




import com.model.constants.Constants;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author wuyuxiao
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public static <T> BaseResponse<T> ok() {
        return restResult(null, Constants.SUCCESS, null);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return restResult(data, Constants.SUCCESS, null);
    }

    public static <T> BaseResponse<T> ok(T data, String msg) {
        return restResult(data, Constants.SUCCESS, msg);
    }

    public static <T> BaseResponse<T> failed() {
        return restResult(null, Constants.FAIL, null);
    }

    public static <T> BaseResponse<T> failed(String msg) {
        return restResult(null, Constants.FAIL, msg);
    }

    public static <T> BaseResponse<T> failed(T data) {
        return restResult(data, Constants.FAIL, null);
    }

    public static <T> BaseResponse<T> failed(T data, String msg) {
        return restResult(data, Constants.FAIL, msg);
    }

    public static <T> BaseResponse<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> BaseResponse<T> restResult(T data, int code, String msg) {
        BaseResponse<T> apiResult = new BaseResponse<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
