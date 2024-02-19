package com.yjxw.exception;

import com.yjxw.model.Result;
import com.yjxw.model.constant.ResponseConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class) // 捕获所有异常
//    @ResponseBody // 使得可以返回JSON格式的错误信息
    public Result<Object> handleAllExceptions(Exception ex) {
        // 日志记录异常，此处使用ex.getMessage()获取异常信息，实际使用时可以根据需求调整
        log.error("An error occurred: ", ex);
        return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

}

