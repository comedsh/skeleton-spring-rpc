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
	ISpitterRemoteService rmiService;
	
	@Autowired
	@Qualifier("spitterHessionRemoteService")
	ISpitterRemoteService hessianService; 

	@Autowired
	@Qualifier("spitterBurlapRemoteService")
	ISpitterRemoteService burlapService; 	

	@Autowired
	@Qualifier("spitterHttpInvokerRemoteService")
	ISpitterRemoteService httpInvokerService; 	
	
	
	@Before
	public void before(){
		
		rmiService.clear();
		
		hessianService.clear();
		
		burlapService.clear();
		
		httpInvokerService.clear();
	
	}
	
	@Test 
	public void testRMI(){
		
		// add a new Spitter
		
		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine?", new Date() );
		
		SpittleDTO st3 = new SpittleDTO(sr, "and you?", new Date() );
		
		rmiService.saveSpitter( sr );
		
		rmiService.saveSpittle( st1 );
		
		rmiService.saveSpittle( st2 );
		
		rmiService.saveSpittle( st3 );
		
		assertEquals( 3, rmiService.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", rmiService.getSpitter("sh").getFullName() );
		
	}
	
	@Test
	public void testHession(){

		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine?", new Date() );
		
		SpittleDTO st3 = new SpittleDTO(sr, "and you?", new Date() );
		
		hessianService.saveSpitter( sr );
		
		hessianService.saveSpittle( st1 );
		
		hessianService.saveSpittle( st2 );
		
		hessianService.saveSpittle( st3 );
		
		assertEquals( 3, hessianService.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", hessianService.getSpitter("sh").getFullName() );		
		
	}
	
	@Test
	public void testBurlap(){
		
		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine?", new Date() );
		
		SpittleDTO st3 = new SpittleDTO(sr, "and you?", new Date() );
		
		burlapService.saveSpitter( sr );
		
		burlapService.saveSpittle( st1 );
		
		burlapService.saveSpittle( st2 );
		
		burlapService.saveSpittle( st3 );
		
		assertEquals( 3, burlapService.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", burlapService.getSpitter("sh").getFullName() );		
		
	}
	
	@Test
	public void testHttpInvoker(){
		
		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine?", new Date() );
		
		SpittleDTO st3 = new SpittleDTO(sr, "and you?", new Date() );
		
		httpInvokerService.saveSpitter( sr );
		
		httpInvokerService.saveSpittle( st1 );
		
		httpInvokerService.saveSpittle( st2 );
		
		httpInvokerService.saveSpittle( st3 );
		
		assertEquals( 3, httpInvokerService.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", httpInvokerService.getSpitter("sh").getFullName() );	
		
	}
	
	
}
