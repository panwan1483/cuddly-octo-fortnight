package com.sps.ecommerce.admin.common.sms;

/***
 * 短信消息对象
 * @author wangfucai
 */
public class SmsMessage {

	/***
	 * 返回的消息
	 */
	private String message;
	
	/**
	 * 返回的状态码
	 * 
	 */
	private String code;

	/***
	 * 所属产品
	 */
	private String product;
	
	public SmsMessage() {
		super();
	}

	public SmsMessage(String message, String code, String product) {
		super();
		this.message = message;
		this.code = code;
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsMessage [message=");
		builder.append(message);
		builder.append(", code=");
		builder.append(code);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
}