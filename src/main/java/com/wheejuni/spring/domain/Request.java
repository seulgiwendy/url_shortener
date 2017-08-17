package com.wheejuni.spring.domain;

public class Request {
	
	String requestedUrl;
	String desiredUrl;
	
	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}
	
	public String getRequestedUrl() {
		return this.requestedUrl;
	}
	
	public void setDesiredUrl(String desiredUrl) {
		this.desiredUrl = desiredUrl;
	}
	
	public String getDesiredUrl() {
		return this.desiredUrl;
	}

}
