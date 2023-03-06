package com.wiseboy.weatherservice.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private final String message;
    private final int errorCode;

    public BusinessException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
