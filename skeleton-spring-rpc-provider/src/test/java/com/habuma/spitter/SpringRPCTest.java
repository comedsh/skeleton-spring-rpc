package com.habuma.spitter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.service.SpitterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class SpringRPCTest {

	@Autowired
	SpitterService service;
	
	
	@Test
	public void test(){
	
		assertTrue(true);
		
	}
	
}
