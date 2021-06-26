package com.uio.java_tools.resq;

public class StringDataReq {

    /**
     * 输入字符串
     */
    private String data;

    public StringDataReq() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StringDateMessage{" +
                "data='" + data + '\'' +
                '}';
    }
}
