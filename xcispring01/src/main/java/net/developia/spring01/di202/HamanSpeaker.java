package net.developia.spring01.di202;

import org.springframework.stereotype.Component;

@Component(value="harman")
public class HamanSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("HarmanSpeaker : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("HarmanSpeaker : 소리를 줄입니다.");
	}

}
