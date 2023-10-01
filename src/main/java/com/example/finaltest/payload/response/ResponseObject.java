package com.example.finaltest.payload.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.time.LocalDate;
@Component
@Data
public class ResponseObject<T> {
    private int status;
    private String message;
    private int code;
    private LocalDate dateResponse;
    private T data;

    public ResponseObject() {

    }
    public ResponseObject(int status, String message, int code, LocalDate dateResponse, T data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.dateResponse = dateResponse;
        this.data = data;
    }
    public ResponseObject<T> responseSuccess(String message, T data){
        return new ResponseObject<T>(0, message, HttpURLConnection.HTTP_OK, LocalDate.now(), data);
    }
    public ResponseObject<T> responseError(int statusCode, String message, T data){
        return new ResponseObject<T>(0, message, statusCode, LocalDate.now(), data);
    }
}
