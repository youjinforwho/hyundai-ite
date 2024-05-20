package net.developia.spring01.di301;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("SamsungTV : 제품이 생산되었습니다.");
	}
	public void powerOn() {
		System.out.println("SamsungTV : TV를 켭니다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV : TV를 끕니다.");
	}
	public void channelUp() {
		System.out.println("SamsungTV : 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("SamsungTV : 채널을 내립니다.");
	}
	public void soundUp() {
		if (speaker == null) System.out.println("SamsungTV : 소리를 키웁니다.");
		else speaker.soundUp();
	}
	public void soundDown() {
		if (speaker == null) System.out.println("SamsungTV : 소리를 줄입니다.");
		else speaker.soundDown();
	}
}
