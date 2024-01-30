package com.demo.contacts.Auth.Domain.Dto;

public class ResponseDto {
    private int codeOfErrors;
    private String message;

    public int getCodeOfErrors() {
        return codeOfErrors;
    }

    public void setCodeOfErrors(int codeOfErrors) {
        this.codeOfErrors = codeOfErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
