package net.developia.spring01.di301e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("net/developia/spring01/di301e/system.properties")
public class BeanInit {
	@Bean
	public FileOutputter fileOutputter() {
		return new FileOutputterImpl();
	}
	
	@Bean
	public Outputter output() {
		//생성자 주입
//		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
//		return tv;
		return new OutputterImpl();
	}
	
}