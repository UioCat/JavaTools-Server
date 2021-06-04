package com.example.java_tools.utils.json_msg;

public class StringDataMessage {

    private String data;

    public StringDataMessage() {
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
