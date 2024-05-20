package net.developia.spring01.di201;

import org.springframework.stereotype.Component;

@Component(value="orange")
public class OrangeSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("OrangeSpeaker : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("OrangeSpeaker : 소리를 줄입니다.");
	}

}
