package com.handykrafts.response;

import org.json.simple.JSONObject;

public class Response {

	private boolean status;
	private String message;
	private JSONObject payload;

	public Response() {
	}

	public Response(boolean status, String message, JSONObject payload) {
		super();
		this.status = status;
		this.message = message;
		this.payload = payload;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JSONObject getPayload() {
		return payload;
	}

	public void setPayload(JSONObject payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", payload=" + payload + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
