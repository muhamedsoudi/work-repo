package com.agilebis.test.assessmentDemo.exception;

public class DBAuthenticationSecurityException extends RuntimeException {

    private static final long serialVersionUID = 4570573798200354363L;

    public DBAuthenticationSecurityException(String msg) {
        super(msg);
    }

    public DBAuthenticationSecurityException(Throwable cause) {
        super(cause);
    }

    public DBAuthenticationSecurityException(String msg, Throwable cause) {
        super(msg, cause);
    }

}