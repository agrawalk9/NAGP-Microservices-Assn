package com.nagp.servicereceiver.facade;

import java.util.List;

public interface Facade {

	String requestForService(String type, String id);
	
	List<String> getReqStatus(String id);
}