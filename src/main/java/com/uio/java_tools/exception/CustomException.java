package com.uio.java_tools.exception;

import com.uio.java_tools.enums.BackEnum;

public class CustomException extends RuntimeException{

    private Integer code;

    public CustomException(BackEnum backEnum){
        super(backEnum.getMessage());
        this.code=backEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
