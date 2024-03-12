package com.yjxw.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private int code; // 状态码
    private String message; // 返回消息
    private T data; // 携带的数据

    // 构造函数
    public Result() {}

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速创建Result对象的静态方法
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功");
    }
    public static <T> Result<T> success(String message) {
        return new Result<>(200, message);
    }
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> error(int code, String message, T data) {
        return new Result<>(code, message, data);
    }
}

