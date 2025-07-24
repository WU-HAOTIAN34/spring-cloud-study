package com.atg.handler;


import com.atg.enumerate.ReturnCode;
import com.atg.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public Result<String> handleException(Exception e) {
//        log.error("异常处理:{}", e.getMessage());
//        return Result.fail(ReturnCode.RC500.getCode(), e.getMessage());
//    }
}
