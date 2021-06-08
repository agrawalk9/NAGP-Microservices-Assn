package com.nagp.serviceprovider.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.serviceprovider.facade.Facade;

@RestController
public class Endpoint {

	@Autowired
	public Facade facade;
	
	@PostMapping("/serviceResponse")
	public ResponseEntity<?> register(@RequestParam String receiverId, @RequestParam String providerId, @RequestParam String reqType, @RequestParam String status) {
		return new ResponseEntity(facade.serviceResponse(receiverId, providerId, reqType, status), HttpStatus.OK);
	}
}
