package com.yjxw.exception;

import com.yjxw.model.Result;
import com.yjxw.model.constant.ResponseConstant;
import com.yjxw.model.constant.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 参数校验失败异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return Result.error(ResponseConstant.BAD_REQUEST.getCode(), ResultMessage.PARAMETER_VALIDATION_FAILED, errors);
    }


    @ExceptionHandler(Exception.class) // 捕获所有异常
//    @ResponseBody // 使得可以返回JSON格式的错误信息
    public Result<Object> handleAllExceptions(Exception ex) {
        // 日志记录异常，此处使用ex.getMessage()获取异常信息，实际使用时可以根据需求调整
        log.error("An error occurred: ", ex);
        return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

}

