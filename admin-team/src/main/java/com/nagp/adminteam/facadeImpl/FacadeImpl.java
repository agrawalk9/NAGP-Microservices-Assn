package com.nagp.adminteam.facadeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.adminteam.facade.Facade;
import com.nagp.adminteam.services.Services;

@Service
public class FacadeImpl implements Facade {

	@Autowired
	public Services services;
	
	@Override
	public String service(String type, int id) {
		return services.service(type, id);
	}
}
