package com.habuma.spitter;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class SpringRPCTest {

	@Autowired
	SpitterService service;
	
	@Test 
	public void testRMI(){
		
		// add a new Spitter
		
		Spitter sr = new Spitter("sh", "shangyang", "comedshang@163.com");
		
		Spittle st1 = new Spittle(sr, "how are you?", new Date() );
		
		Spittle st2 = new Spittle(sr, "I'm fine?", new Date() );
		
		Spittle st3 = new Spittle(sr, "and you?", new Date() );
		
		service.saveSpitter( sr );
		
		service.saveSpittle( st1 );
		
		service.saveSpittle( st2 );
		
		service.saveSpittle( st3 );
		
		assertEquals( 3, service.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", service.getSpitter("sh").getFullName() );
		
	}
	
	@Test
	public void testHession(){
		
	}
	
	@Test
	public void testHttpInvoker(){
		
	}
	
	
}
