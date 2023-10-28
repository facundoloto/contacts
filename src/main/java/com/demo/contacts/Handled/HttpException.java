package com.demo.contacts.Handled;

public class HttpException extends RuntimeException {
private final hadledHttps hadledHttps;

    public HttpException(hadledHttps hadledHttps) {
        super(hadledHttps.getMessage());
        this.hadledHttps = hadledHttps;
    }


    public int getHadledHttps() {
        return hadledHttps.getHttpStatus();
    }
}