package com.roytuts.spring.websocket.vo;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private String msg;

	public Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
