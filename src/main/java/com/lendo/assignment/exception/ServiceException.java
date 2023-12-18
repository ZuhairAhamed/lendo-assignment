package com.lendo.assignment.exception;

import java.net.FileNameMap;

public class ServiceException extends Exception{

    private String message;

    private String statusCode;

    public ServiceException(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
