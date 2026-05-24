package com.mango.productservice.exceptions;

public class MessageResponse <T>{
    private T data;
    private String message;
    private boolean success;
    private String errorCode;
    public MessageResponse() {}
    public MessageResponse(T data, String message, boolean success, String errorCode) {
        this.data = data;
        this.message = message;
        this.success = success;
        this.errorCode = errorCode;
    }
}
