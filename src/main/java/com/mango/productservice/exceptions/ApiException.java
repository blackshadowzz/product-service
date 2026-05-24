package com.mango.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApiException  extends RuntimeException{
    private String message;
    private String error;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
        this.message = message;
    }
    public ApiException(String error, Throwable cause){
        super(error);
        this.error = error;
        this.message = cause.getMessage();
    }
    public ApiException(String message, String error) {
        super(message);
        this.message = message;
        this.error = error;
    }
}
