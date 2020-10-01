package com.arindam.microservice.entity.test;

public class MicroServiceTestBean {
    private String message;

    public MicroServiceTestBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MicroServiceTestBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
