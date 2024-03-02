package com.yjxw.model.service_response;

import lombok.Data;

@Data
public class ServiceResponse {
    private String message;  // 返回消息
    private boolean success; // 是否成功

    public static ServiceResponse success(String message) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage(message);
        return serviceResponse;
    }
    public static ServiceResponse error(String message) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setSuccess(false);
        serviceResponse.setMessage(message);
        return serviceResponse;
    }
}
