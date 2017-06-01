package com.sps.ecommerce.admin.exception;

/**
 * 服务层异常
 * @author wangfucai
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 5393689702766404499L;
	
	private String message;
	
	public ServiceException(String message)
	{
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}