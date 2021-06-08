package com.nagp.servicereceiver.services;

import java.util.List;

public interface Services {

	String requestForService(String type, String id);
	
	List<String> getReqStatus(String id);
}