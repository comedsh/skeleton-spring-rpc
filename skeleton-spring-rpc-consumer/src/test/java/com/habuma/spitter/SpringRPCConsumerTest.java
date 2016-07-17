package com.habuma.spitter;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shangyang.remote.dto.Account;
import org.shangyang.remote.dto.Customer;
import org.shangyang.remote.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;
import com.habuma.spitter.remote.service.ISpitterRemoteService;

/**
 * 
 * 特别注意：
 * 
 * 测试的时候一定记得要运行 skeleton-spring-rpc-service web 容器，否则，SpringRPCTest 启动测试的时候会因为连接不上远程服务而报错，主要是类似于 hessian、burlap、http invoker 依赖 HTTP 协议的远程调用。
 * 
 * @author 商洋
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class SpringRPCConsumerTest {

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
	
	
	@Autowired
	@Qualifier("jaxwsRemoteService")
	ISpitterRemoteService jaxwsRemoteService; 		

	@Autowired
	@Qualifier("jaxwsRemoteService2")
	ISpitterRemoteService jaxwsRemoteService2; 		
	
	@Autowired
	@Qualifier("accountService")
	IAccountService accountService; // invoke the web service end point delegated by AccountServiceEndPoint
	
	@Autowired
	@Qualifier("accountService2")
	IAccountService accountService2; // invokes the web service end point direct by AccountServiceImpl
	
	@Autowired
	JmsTemplate jmsTemplate;	
	
	@Before
	public void before(){
		
		rmiService.clear();
		
		hessianService.clear();
		
		burlapService.clear();
		
		httpInvokerService.clear();
		
		jaxwsRemoteService.clear();
		
		accountService.clear();
	
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
	
	@Test
	public void testJaxws(){
		
		// 参看 testJaxws2() 代码逻辑，参数对象不能使用带参的构造函数，否则会出现 javax.xml.ws.WebServiceException: java.net.SocketException: Unexpected end of file from server
		SpitterDTO sr = new SpitterDTO("sh", "shangyang", "comedshang@163.com");
//		sr.setUsername("sh");
//		sr.setFullName("shangyang");
//		sr.setEmail("comedshang@163.com");
		
		SpittleDTO st1 = new SpittleDTO(sr, "how are you?", new Date() );
//		st1.setSpitter(sr);
//		st1.setText("how are your?");
//		st1.setWhen(new Date());
		
		SpittleDTO st2 = new SpittleDTO(sr, "I'm fine!", new Date() );
//		st2.setSpitter(sr);
//		st2.setText("I'm fine?");
//		st2.setWhen(new Date());
		
		SpittleDTO st3 = new SpittleDTO(sr, "and your?", new Date() );
//		SpittleDTO st3 = new SpittleDTO();
//		st3.setSpitter(sr);
//		st3.setText("and you?");
//		st3.setWhen(new Date());
		
		jaxwsRemoteService2.saveSpitter( sr );
		
		jaxwsRemoteService2.saveSpittle( st1 );
		
		jaxwsRemoteService2.saveSpittle( st2 );
		
		jaxwsRemoteService2.saveSpittle( st3 );
		
		assertEquals( 3, jaxwsRemoteService2.getSpittlesForSpitter( sr ).size() );
		
		assertEquals( "shangyang", jaxwsRemoteService2.getSpitter("sh").getFullName() );			
		
	}
	
	@Test
	public void testJaxws2(){
		
		// 下面这行代码模拟出来了错误
		// Could not access remote service at [null]; nested exception is javax.xml.ws.WebServiceException: java.net.SocketException: Unexpected end of file from server
		// 看来，如果使用 Spring JAX-WS 对象参数不能使用带参的构造函数
		// Account a = new Account("ss");
		
		Account a = new Account("ss");
		
		//a.setName("ss");
		
		Customer c = new Customer("cc");
		
		// c.setName("cc");
		
		a.setCustomer( c );
		
		accountService.insertAccount(a);
		
		List<Account> accounts = accountService.getAccounts("ss");
		
		assertEquals(accounts.size(), 1);
		
	}

	@Test
	public void testJaxws2_2(){
		
		Account a = new Account("ss");

		Customer c = new Customer();
		
		c.setName("cc");
		
		a.setCustomer( c );		
		
		accountService2.insertAccount(a);
		
		List<Account> accounts = accountService2.getAccounts("ss");
		
		assertEquals(accounts.size(), 1);
		
	}	
	
	@Test
	public void testMQ_01(){
		  
	    try {
	    	
	      ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive("spitter.alert.queue"); //<co id="co_receive"/>
	      
	      SpitterDTO spitterDto = (SpitterDTO) receivedMessage.getObject(); // 此方法会一直阻塞，直到有消息到达... 跟 Java 最老的 IO 很类似。
	      
	      assertEquals("sh", spitterDto.getUsername());
	      
	      assertEquals("shangyang", spitterDto.getFullName() );
	      
	      assertEquals("comedshang@163.com", spitterDto.getEmail());	      
	      
	    } catch (JMSException jmsException) {
	    	
	      throw JmsUtils.convertJmsAccessException(jmsException);//<co id="co_throwException"/>
	      
	    }
		  		
		
	}
	
	
}
