package com.nagp.serviceprovider.facadeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.serviceprovider.facade.Facade;
import com.nagp.serviceprovider.services.Services;

@Service
public class FacadeImpl implements Facade {
	
	@Autowired
	public Services services;
	
	@Override
	public String serviceResponse(String receiverId, String providerId, String reqType, String status) {
		return services.serviceResponse(receiverId, providerId, reqType, status);
	}
}
