package com.nagp.serviceprovider.dummy.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nagp.serviceprovider.model.ServiceProvider;

@Service
public class ServiceProviderDummyData {

	public Map<String, Map<String, ServiceProvider>> serviceMap = new HashMap();
	
	public ServiceProviderDummyData() {
		Map<String, ServiceProvider> area1 = new HashMap();
		area1.put("electrician", new ServiceProvider("1", "Provider1", "electrician", "1234567890", true));
		area1.put("yogaTrainer", new ServiceProvider("2", "Provider2", "yogaTrainer", "1234567890", false));
		area1.put("interiorDesigner", new ServiceProvider("3", "Provider3", "interiorDesigner", "1234567890", true));
		area1.put("gymTrainer", new ServiceProvider("4", "Provider4", "gymTrainer", "1234567890", false));

		Map<String, ServiceProvider> area2 = new HashMap();
		area2.put("electrician", new ServiceProvider("5", "Provider1", "electrician", "1234567890", true));
		area2.put("yogaTrainer", new ServiceProvider("6", "Provider2", "yogaTrainer", "1234567890", false));
		area2.put("interiorDesigner", new ServiceProvider("7", "Provider3", "interiorDesigner", "1234567890", true));
		area2.put("gymTrainer", new ServiceProvider("8", "Provider4", "gymTrainer", "1234567890", false));

		Map<String, ServiceProvider> area3 = new HashMap();
		area3.put("electrician", new ServiceProvider("9", "Provider1", "electrician", "1234567890", true));
		area3.put("yogaTrainer", new ServiceProvider("10", "Provider2", "yogaTrainer", "1234567890", false));
		area3.put("interiorDesigner", new ServiceProvider("11", "Provider3", "interiorDesigner", "1234567890", true));
		area3.put("gymTrainer", new ServiceProvider("12", "Provider4", "gymTrainer", "1234567890", false));

		Map<String, ServiceProvider> area4 = new HashMap();
		area4.put("electrician", new ServiceProvider("13", "Provider1", "electrician", "1234567890", true));
		area4.put("yogaTrainer", new ServiceProvider("14", "Provider2", "yogaTrainer", "1234567890", false));
		area4.put("interiorDesigner", new ServiceProvider("15", "Provider3", "interiorDesigner", "1234567890", true));
		area4.put("gymTrainer", new ServiceProvider("16", "Provider4", "gymTrainer", "1234567890", false));

		Map<String, ServiceProvider> area5 = new HashMap();
		area5.put("electrician", new ServiceProvider("17", "Provider1", "electrician", "1234567890", true));
		area5.put("yogaTrainer", new ServiceProvider("18", "Provider2", "yogaTrainer", "1234567890", false));
		area5.put("interiorDesigner", new ServiceProvider("19", "Provider3", "interiorDesigner", "1234567890", true));
		area5.put("gymTrainer", new ServiceProvider("20", "Provider4", "gymTrainer", "1234567890", false));

		serviceMap.put("Area1", area1);
		serviceMap.put("Area2", area2);
		serviceMap.put("Area3", area3);
		serviceMap.put("Area4", area4);
		serviceMap.put("Area5", area5);
	}
}
