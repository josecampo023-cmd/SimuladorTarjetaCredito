package com.example.simulador.exception;

public class BusinessErrorResponse {
    private String code;
    private String title;
    private String detail;

    public BusinessErrorResponse(String code, String title, String detail) {
        this.code = code;
        this.title = title;
        this.detail = detail;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getDetail() { return detail; }
}
