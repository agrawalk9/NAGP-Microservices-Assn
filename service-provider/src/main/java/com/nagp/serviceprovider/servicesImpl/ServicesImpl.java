package com.nagp.serviceprovider.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.serviceprovider.dummy.data.ServiceProviderDummyData;
import com.nagp.serviceprovider.services.Services;
import com.netflix.discovery.EurekaClient;

@Service
public class ServicesImpl implements Services {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public ServiceProviderDummyData data;
	
	@Autowired
	public EurekaClient eurekaClient;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public String serviceResponse(String receiverId, String providerId, String reqType, String status) {
		String url = eurekaClient.getNextServerFromEureka("api-gatewayy", false).getHomePageUrl() + "order-service/updateOrder?userId=" + receiverId + "&reqStatus=" + status
				+ "&reqType=" + reqType + "&providerId=" + providerId;
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
		
		if(status.equals("CONFIRMED") && response.getBody().equals("Status Updated")) {
			//notification to receiver with service provider details
			jmsTemplate.convertAndSend("NotifyReceiverConfirmEvent", receiverId);	
		} else {
			jmsTemplate.convertAndSend("NotifyReceiverDeclineEvent", receiverId);	
		}
		return response.getBody() + " & User Notified";
	}
}
