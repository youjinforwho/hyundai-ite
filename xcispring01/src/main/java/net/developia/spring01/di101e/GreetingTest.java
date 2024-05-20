package net.developia.spring01.di101e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(GreetingTest.class, "beaninit.xml");
		
		System.out.println("======================================");
		Outputter output = (Outputter) context.getBean("greeting");
		output.greeting();
	}
}
