package com.habuma.spitter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.service.AlertService;

/**
 * 如果 skeleton-spring-rpc-provider web 容器启动，这里执行 JUnit 测试环境再次初始化 Spring 容器会报错 - address already been in used，rmi、hessian、burlap 的 address 都在容器启动的时候使用过了啊... 
 * 
 * 所以，在调用该测试用力的时候，需要把 web container 给关闭掉。测试 consumer test 的时候再启动，不过没关系，因为 provider 测试用例并不多，目前只有 JMS...
 * 
 * 不过最好的办法是通过 web 容器发送 jms 消息
 * 
 * @author 商洋
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class SpringRPCProviderTest {
	
	@Autowired
	AlertService alertServie;
	
	@Test
	public void testJms(){
		
		alertServie.sendSpittleAlert( new SpitterDTO("sh", "shangyang", "comedshang@163.com") );
		
	}
	
}
