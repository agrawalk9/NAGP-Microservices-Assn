package com.nagp.servicereceiver.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.servicereceiver.services.Services;
import com.netflix.discovery.EurekaClient;

@Service
public class ServicesImpl implements Services {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public EurekaClient eurekaClient;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public String requestForService(String type, String id) {
		String url = eurekaClient.getNextServerFromEureka("api-gatewayy", false).getHomePageUrl() + "admin-team/registerService?type=" + type + "&id=" + id;
		System.out.println("url = " + url);
//		logger.info("url = " +url);
		// request body parameters
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "John Doe");
//		map.put("job", "Java Developer");

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
		logger.info("Service Receiver");
		return response.getBody();
	}

	@Override
	public List<String> getReqStatus(String id) {
		
		String url = eurekaClient.getNextServerFromEureka("api-gatewayy", false).getHomePageUrl() + "order-service/getOrders?userId=" + id;
		System.out.println(url);
		// send POST request
		ResponseEntity<String[]> response = restTemplate.exchange(url, HttpMethod.GET, null, String[].class);
		logger.info("Service Receiver");
		if(response.getBody()!=null) {
			return Arrays.asList(response.getBody());
		} else {
			return null;
		}
	}
}
