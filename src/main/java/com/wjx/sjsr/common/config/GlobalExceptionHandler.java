package com.wjx.sjsr.common.config;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.BaseException;
import com.wjx.sjsr.common.vo.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

/***
 * @classname:
 * @description:
 * @author: wjx
 * @date: 2019/10/24 10:29
 */
@ControllerAdvice
public class GlobalExceptionHandler implements HandlerInterceptor {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(Exception ex) {
        if (ex instanceof BaseException) {
            Integer errorCode = ((BaseException) ex).getErrorCode() ==null?200:((BaseException) ex).getErrorCode();
            return new Result(errorCode, ((BaseException) ex).getErrorMessage());
        }else if (ex instanceof BindException) {
            ex.printStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("参数错误：");
            ((BindException) ex).getAllErrors().forEach(e -> stringBuffer.append(e.getDefaultMessage()).append(","));
            return new Result(ResultStatusCode.BAD_REQUEST.getCode(), stringBuffer.toString());
        }else if(ex instanceof MethodArgumentNotValidException){
            ex.printStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("参数错误：");
            ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach(e -> stringBuffer.append(e.getDefaultMessage()).append(","));
            return new Result(ResultStatusCode.BAD_REQUEST.getCode(), stringBuffer.toString());
        }else if (ex instanceof RuntimeException) {
            ex.printStackTrace();
            return new Result(ResultStatusCode.BAD_REQUEST.getCode(), "运行时异常");
        } else {
            ex.printStackTrace();
            return new Result(ResultStatusCode.BAD_REQUEST.getCode(), "系统错误");
        }

    }

}