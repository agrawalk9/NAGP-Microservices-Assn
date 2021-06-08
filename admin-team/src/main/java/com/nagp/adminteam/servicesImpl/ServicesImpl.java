package com.nagp.adminteam.servicesImpl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.adminteam.dummy.data.DummyData;
import com.nagp.adminteam.model.ServiceProvider;
import com.nagp.adminteam.model.User;
import com.nagp.adminteam.services.Services;
import com.netflix.discovery.EurekaClient;

@Service
public class ServicesImpl implements Services {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DummyData data;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	public EurekaClient eurekaClient;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public String service(String type, int id) {
		logger.info("Admin Service");
		User user = data.userMap.get(id);
		if (user != null) {
			Map<String, ServiceProvider> servicesAvailable = data.serviceMap.get(user.getAddress());
			try {
			ServiceProvider s = servicesAvailable.get(type);
				if (s.getAvailable()) {
					String url = eurekaClient.getNextServerFromEureka("api-gatewayy", false).getHomePageUrl() + "order-service/createOrder?userId=" + user.getId()
							+ "&reqStatus=PROCESSING&reqType=" + type;
					ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
					jmsTemplate.convertAndSend("NotifyProviderForServiceRequest", s.getId());
					return response.getBody();	
				}
				return "Not Available in your area";
			} catch(Exception ex) {
				return "Not Available in your area";
			}
		} else {
			return "User Not Found";
		}
	}
}
