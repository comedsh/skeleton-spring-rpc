package com.habuma.spitter.client.mq;

import org.apache.commons.lang.StringUtils;

import org.springframework.util.Assert;

import com.habuma.spitter.remote.dto.SpitterDTO;

/**
 * 
 * Pay attention, need to configure the SpitterDTO as trusted classes
 * 
 * Caused by: java.lang.ClassNotFoundException: Forbidden class com.habuma.spitter.remote.dto.SpitterDTO! This class is not trusted to be serialized as ObjectMessage payload. 
 * Please take a look at http://activemq.apache.org/objectmessage.html for more information on how to configure trusted classes.
 *
 * http://activemq.apache.org/objectmessage.html
 * 
 * 上面的描述有问题，实际上根本用不着 CAMEL。所以，将 CAMEL 相关的 spring-context 注释掉，gradle 中引用的包给注释掉了。要注意的是，consumer 端，需要使用的是 activemq-client 而不是 activemq-core
 * 
 * @author 商洋
 *
 */
public class SpitterAlertHandler {
  
	public void processSpitter( SpitterDTO spitterDto ) {
	  
	  Assert.isTrue( StringUtils.equals( "sh", spitterDto.getUsername() ) && StringUtils.equals( "shangyang", spitterDto.getFullName() ) );
	  
	  System.out.println( "Handler processed: " + spitterDto.getFullName() );
	  
	}
 
}
