package com.example.CloudFarm.enums;


public enum HttpStatus {

	/*
	 * 操作成功
	 */
	SUCCESS(200),

	UNAUTHORIZED(401),

	FORBIDDEN(403),

	NOT_FOUND(404),

	DATA_ERROR(9001),

	DATA_DELETE_ERROR(9002),

	DATA_UPDATE_ERROR(9003),

	ERROR(500),

	BAD_REQUEST(400);

	private int code;

	private HttpStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
