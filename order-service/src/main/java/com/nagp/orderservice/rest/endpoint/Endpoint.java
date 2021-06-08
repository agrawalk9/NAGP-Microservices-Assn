package com.nagp.orderservice.rest.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.orderservice.model.Order;

@RestController
public class Endpoint {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	public Map<String, ArrayList<Order>> orderMap = new HashMap();

	@PostMapping("/createOrder")
	public ResponseEntity<?> createOrder(@RequestParam String userId, @RequestParam String reqStatus,
			@RequestParam String reqType) {
		ArrayList<Order> l = orderMap.get(userId);
		if (l != null) {
			l.add(new Order(l.size() + 1, reqStatus, reqType, userId));
			orderMap.put(userId, l);
		} else {
			ArrayList<Order> temp = new ArrayList();
			temp.add(new Order(1, reqStatus, reqType, userId));
			orderMap.put(userId, temp);
		}
		logger.info("Order Service");
		return new ResponseEntity(reqStatus, HttpStatus.OK);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<String> updateOrder(@RequestParam String userId, @RequestParam String reqStatus,
			@RequestParam String reqType, @RequestParam String providerId) {
			List<Order> l = orderMap.get(userId);
			logger.info("Order Service");
			if (l != null) {
				for (int i = 0; i < l.size(); i++) {
					Order o = l.remove(i);
					if (reqType.equals(o.getReqType())) {
						o.setReqStatus(reqStatus);
						o.setProviderId(providerId);
						l.add(i, o);
						return new ResponseEntity("Status Updated", HttpStatus.OK);
					}
				}
				return new ResponseEntity("No order found", HttpStatus.OK);
			} else {
				return new ResponseEntity("No Orders found", HttpStatus.OK);
			}
	}

	@GetMapping("/getOrders")
	public List<String> getOrders(@RequestParam String userId) {
		logger.info("Order Service");
		List<String> l = new ArrayList<String>();
		try {
			List<Order> l1 = orderMap.get(userId);
			for(Order o:l1) {
				l.add(o.getReqType()+"::"+o.getReqStatus());
			}
			return l;
		} catch(Exception ex) {
			return null;
		}
	}
}
