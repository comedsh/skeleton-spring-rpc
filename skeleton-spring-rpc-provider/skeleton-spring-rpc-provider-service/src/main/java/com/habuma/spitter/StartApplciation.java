package com.habuma.spitter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Start the RPC Exporter by Spring Container.
 * 
 * @author 商洋
 *
 */
public class StartApplciation {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("spring-context.xml");
	    
	}
	
}
