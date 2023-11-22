package com.example.demo.common.global;

import com.example.demo.common.exception.ParamsException;
import com.example.demo.common.exception.ParamsLeakException;
import com.example.demo.common.exception.ParamsTypeErrorException;
import com.example.demo.common.exception.ProcessException;
import com.example.demo.common.factory.Response;

import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response<Null> handleException(Exception e) {
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(ParamsException.class)
    public Response<Null> handleParamsException(ParamsException e) {
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(ParamsLeakException.class)
    public Response<Null> handleParamsLeakException(ParamsLeakException e) {
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(ParamsTypeErrorException.class)
    public Response<Null> handleParamsTypeException(ParamsTypeErrorException e) {
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(ProcessException.class)
    public Response<Null> handleProcessException(ProcessException e) {
        return Response.fail(e.getMessage());
    }
}
