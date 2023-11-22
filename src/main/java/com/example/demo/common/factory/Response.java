package com.example.demo.common.factory;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.jdbc.Null;

@Data
@Accessors(chain = true)
public class Response<T> {
    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

    public static final String SUCCESS_MSG = "success";
    public static final String FAIL_MSG = "fail";

    private Integer code = Response.SUCCESS_CODE;

    private String msg = Response.SUCCESS_MSG;


    private T data = null;

    private Response() {
    }

    public static Response success() {
        return new Response<>();
    }

    public static <R> Response<R> success(R data) {
        Response<R> response = new Response<R>();
        response.setData(data);
        return response;
    }

    public static Response fail() {
        Response response = new Response<>();
        response.setCode(Response.FAIL_CODE);
        response.setMsg(Response.FAIL_MSG);
        return response;
    }

    public static Response<Null> fail(String msg) {
        Response response = new Response();
        response.setCode(Response.FAIL_CODE);
        response.setMsg(msg);
        return response;
    }

    public static <R> Response<R> response(Integer code, String msg, R data) {
        return new Response<R>(code, msg, data);
    }

    public Response<T> status(Integer code){
        this.code = code;
        return this;
    }
    public Response<T> body(T data){
        this.data = data;
        return this;
    }
}
