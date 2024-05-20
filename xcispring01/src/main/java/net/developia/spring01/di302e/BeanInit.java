package net.developia.spring01.di302e;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("net/developia/spring01/di301e/system.properties")
public class BeanInit {
	@Value("${name}")
	String name;
	
	@Value("${greeting}")
	String greeting;
	
	@Bean
	public FileOutputter fileOutputter() {
		return new FileOutputterImpl();
	}
	
	@Bean
	public Outputter output() {
		return new OutputterImpl(fileOutputter(), name, greeting);
	}
	
}