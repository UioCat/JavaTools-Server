package com.example.java_tools.handle;


import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.exception.CustomException;
import com.example.java_tools.utils.BackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackMessage handle(Exception e){

        if(e instanceof CustomException){
            CustomException customException=(CustomException) e;
            logger.warn("自定义异常捕获:{}",customException.getMessage());
            return new BackMessage(customException.getCode(),customException.getMessage());
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            logger.warn("捕捉浏览器错误请求异常");
            return new BackMessage(BackEnum.HTTPERROR);
        }else if(e instanceof MissingServletRequestParameterException){
            logger.warn("捕捉错误参数请求异常");
            return new BackMessage(BackEnum.PARAMERROR);
        }
        else {
            logger.error("系统异常{}",e);
            return new BackMessage(BackEnum.UNKNOW_ERROR);
        }


    }


}