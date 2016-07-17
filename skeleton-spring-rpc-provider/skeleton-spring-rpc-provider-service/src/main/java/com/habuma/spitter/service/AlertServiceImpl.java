package com.habuma.spitter.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {
	  
	@Autowired
	JmsTemplate jmsTemplate;	
	
	public void sendSpittleAlert(final SpitterDTO spitterDto) {
		
		// 如果队列不存在，则新建
		jmsTemplate.send( "spitter.alert.queue",
    		
			new MessageCreator() {     
    	  
				public Message createMessage(Session session) throws JMSException {
	        	
					return session.createObjectMessage( spitterDto );
	          
				}
        
			}
    
		);
    
	}
  
}
