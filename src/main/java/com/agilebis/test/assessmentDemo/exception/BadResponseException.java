package com.agilebis.test.assessmentDemo.exception;

public class BadResponseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadResponseException(String msg) {
        super(msg);
    }

    public BadResponseException(Throwable cause) {
        super(cause);
    }

    public BadResponseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
