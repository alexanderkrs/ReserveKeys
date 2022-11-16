package com.reservekeys.reservekeys.exceptions.service;

public class SeviceErro {
    private String status;
    private String message;

    public SeviceErro(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
