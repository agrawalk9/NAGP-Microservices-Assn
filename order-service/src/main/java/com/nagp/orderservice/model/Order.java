package com.nagp.orderservice.model;

public class Order {

	private int orderId;
	private String reqStatus;
	private String reqType;
	private String receiverId;
	private String providerId;
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public Order(int orderId, String reqStatus, String reqType, String receiverId) {
		super();
		this.orderId = orderId;
		this.reqStatus = reqStatus;
		this.reqType = reqType;
		this.receiverId = receiverId;
	}
}
