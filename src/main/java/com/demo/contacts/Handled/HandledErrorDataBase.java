package com.demo.contacts.Handled;

public enum HandledErrorDataBase  {
    CONNECTION_ERROR("DB-01","Database connection error"),
    SAVE_ERROR("DB-02","DataBase save error"),
    UPDATE_ERROR("DB-03","DataBase update error"),
    DELETE_ERROR("DB-04","DataBase delete error"),
    GET_ERROR("DB-05","DataBase get error"),
    DATA_INTEGRITY_VIOLATION("DB-06","Data integrity violation");
    private final String code;
    private final String message;

    HandledErrorDataBase(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
