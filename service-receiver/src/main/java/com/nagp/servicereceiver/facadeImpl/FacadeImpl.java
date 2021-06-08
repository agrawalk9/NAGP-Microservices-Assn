package com.nagp.servicereceiver.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.servicereceiver.facade.Facade;
import com.nagp.servicereceiver.services.Services;

@Service
public class FacadeImpl implements Facade {

	@Autowired
	public Services services;
	
	@Override
	public String requestForService(String type, String id) {
		return services.requestForService(type, id);
	}
	
	@Override
	public List<String> getReqStatus(String id) {
		return services.getReqStatus(id);
	}
}
