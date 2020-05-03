package com.kitezone.app.ws.exeptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 1226285476338622553L;

    public UserServiceException(String message) {
        super(message);
    }
}
