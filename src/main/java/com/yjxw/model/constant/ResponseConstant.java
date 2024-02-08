package com.yjxw.model.constant;

import lombok.Getter;

@Getter
public enum ResponseConstant {
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private final String message;

    ResponseConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 可以添加根据code获取枚举的方法，便于根据状态码找到对应的枚举
    public static ResponseConstant valueOf(int code) {
        for (ResponseConstant value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("无效的状态码: " + code);
    }
}
