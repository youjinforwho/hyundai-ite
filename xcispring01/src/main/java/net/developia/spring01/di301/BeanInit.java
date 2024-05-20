package net.developia.spring01.di301;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInit {
	@Bean
	public TV tv() {
		//생성자 주입
//		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
//		return tv;
		return new SamsungTV();
	}
	
	@Bean
	public Speaker speaker() {
		return new HamanSpeaker();
	}
}
