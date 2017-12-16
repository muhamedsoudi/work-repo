package com.agilebis.test.assessmentDemo.model.dto;

import java.io.Serializable;

public class ClassicResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private int resultCode;

	private String message;

	public ClassicResponse() {
		super();
	}

	public ClassicResponse(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

}
