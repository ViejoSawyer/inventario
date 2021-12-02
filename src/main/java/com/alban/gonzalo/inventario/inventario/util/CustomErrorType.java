package com.alban.gonzalo.inventario.inventario.util;

public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
