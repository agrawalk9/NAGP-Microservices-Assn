package com.nagp.adminteam.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.adminteam.facade.Facade;

@RestController
public class Endpoints {
	
	@Autowired
	public Facade facade;

	@PostMapping("/registerService")
	public ResponseEntity<?> register(@RequestParam String type, @RequestParam String id) {
		return new ResponseEntity(facade.service(type, Integer.valueOf(id)), HttpStatus.OK);
	}
}
