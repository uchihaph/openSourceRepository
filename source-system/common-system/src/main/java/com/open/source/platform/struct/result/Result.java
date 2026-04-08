package com.open.source.platform.struct.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author hanguo
 * @date 2022/1/14
 * @Description 返回体结构
 */
@Data
public class Result<T> implements Serializable {
    private boolean success;
    private Integer code;
    private T result;
    private long total;
    private String errorCode;
    private String message;
    private Map<String, Object> ext;
    private Map<String, Object> validateErrors;
    private Map<String, Object> header;

    public Result() {
    }

    public Result(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


    public static <T> Result<T> success(T data) {
        return success(data, (String)null, (String)null);
    }

    public static <T> Result<T> success(T data, String message) {
        return success(data, (String)null, message);
    }

    public static <T> Result<T> success(T data, String errorCode, String message) {
        Result<T> result = new Result();
        result.setResult(data);
        result.setMessage(message);
        result.setErrorCode(errorCode);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> fail(String errorCode, String message) {
        return fail(null, errorCode, message);
    }

    public static <T> Result<T> fail(T data, String errorCode, String message) {
        Result<T> result = new Result();
        result.setResult(data);
        result.setMessage(message);
        result.setErrorCode(errorCode);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<List<T>> listSuccess(List<T> data, int total) {
        Result<List<T>> listResult = success(data);
        listResult.setTotal(total);
        return listResult;
    }

    public static <T> Result<List<T>> listSuccess(List<T> data, long total) {
        Result<List<T>> listResult = success(data);
        listResult.setTotal((int)total);
        return listResult;
    }

    public static <T> Result<List<T>> listEmptySuccess() {
        return listSuccess(Collections.emptyList(), 0);
    }

}
