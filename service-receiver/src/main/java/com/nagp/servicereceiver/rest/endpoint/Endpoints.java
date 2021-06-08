package com.nagp.servicereceiver.rest.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.servicereceiver.facade.Facade;
import com.netflix.discovery.EurekaClient;


@RestController
public class Endpoints {
	
	@Autowired
	public EurekaClient eurekaClient;
	
	@Autowired
	public Facade facade;

	@GetMapping("/test")
	public String get() {
		return eurekaClient.getNextServerFromEureka("api-gatewayy", false).getHomePageUrl();
	}
	
	@PostMapping("/requestForService")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> register(@RequestParam String type, @RequestParam String id) {
		return new ResponseEntity(facade.requestForService(type, id), HttpStatus.OK);
	}
	
	@GetMapping("/receiverReqStatus")
	public ResponseEntity<?> getReqStatus(@RequestParam String id) {
		List<String> l = facade.getReqStatus(id);
		if(l!=null) {
			return new ResponseEntity(l, HttpStatus.OK);
		} else {
			return new ResponseEntity("No orders found", HttpStatus.OK);
		}
	}
	
	@GetMapping("/test1/{id}")
	public String test1(@PathVariable String id) {
		return id;
	}
}
