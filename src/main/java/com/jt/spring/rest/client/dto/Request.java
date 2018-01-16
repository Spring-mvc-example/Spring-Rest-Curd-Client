package com.jt.spring.rest.client.dto;

public class Request<T> {

	private T paymentRequest;

	public T getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(T paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

}
