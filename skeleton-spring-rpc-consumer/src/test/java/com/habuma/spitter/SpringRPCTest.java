package com.habuma.spitter;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;
import com.habuma.spitter.remote.service.ISpitterRemoteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class SpringRPCTest {

	@Autowired
	@Qualifier("spitterRmiRemoteService")
	ISpitterRemoteService service;
	
	@Before
	public void before(){
		
		service.clear();
	
	}
	
	@Test 
	public void testRMI(){
		
		// add a new Spitter
		
		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine?", new Date() );
		
		SpittleDTO st3 = new SpittleDTO(sr, "and you?", new Date() );
		
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
