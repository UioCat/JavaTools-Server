package com.example.java_tools.utils;


import com.example.java_tools.enums.BackEnum;

public class BackMessage<T> {

    private Integer code;
    private String message;
    private T info;


    public BackMessage(BackEnum backEnum){
        this.code=backEnum.getCode();
        this.message=backEnum.getMessage();
    }

    public BackMessage(BackEnum backEnum, T t){
        this.code=backEnum.getCode();
        this.message=backEnum.getMessage();
        this.info=t;
    }

    public BackMessage(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BackMessage{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", info=" + info +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
