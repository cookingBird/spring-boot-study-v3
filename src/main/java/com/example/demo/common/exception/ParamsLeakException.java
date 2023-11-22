package com.example.demo.common.exception;

public class ParamsLeakException extends ParamsException{
    public ParamsLeakException() {
    }

    public ParamsLeakException(String message) {
        super(message);
    }
}
