package net.developia.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@Log4j 
public class SampleServiceTests {
	@Autowired
	private SampleService service;
	
	@Test
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info("😊😊😊😊😊😊😊😊😊😊😊😊😊");
		log.info(service.doAdd("123", "456"));
	}
	
	@Test
	public void testAddError() throws Exception {
		log.info(service.doAdd("123", "ABC"));
	}
}
     



