package com.nagp.notificationservice.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Services {

	@JmsListener(destination = "NotifyReceiverConfirmEvent")
	public void confirmServiceResponseToReceiver(String msg) {
		String s = "notification sent to receiver id=" + msg;
		System.out.println(s);
	}

	@JmsListener(destination = "NotifyReceiverDeclineEvent")
	public void declineServiceResponseToReceiver(String msg) {
		String s = "notification sent to receiver id=" + msg;
		System.out.println(s);
	}
	
	@JmsListener(destination = "NotifyProviderForServiceRequest")
	public void toServiceProvider(String msg) {
		String s = "notification sent to provider id=" + msg;
		System.out.println(s);
	}
}
