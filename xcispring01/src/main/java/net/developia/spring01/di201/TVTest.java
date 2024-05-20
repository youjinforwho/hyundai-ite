package net.developia.spring01.di201;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("net/developia/spring01/di201/beaninit.xml");
		
		System.out.println("======================================");
		TV tv1 = (TV) context.getBean("tv", TV.class);
		tv1.powerOn();
		tv1.channelUp();
		tv1.channelUp();
		tv1.soundUp();
		tv1.soundUp();
		tv1.powerOff();
		
		TV tv2 = (TV) context.getBean("tv", TV.class);
		tv2.powerOn();
		tv2.channelUp();
		tv2.channelUp();
		tv2.soundUp();
		tv2.soundUp();
		tv2.powerOff();
		System.out.println(tv1.hashCode() +", " + tv2.hashCode());
	}
}
