package net.developia.oop5;

public class AppleTV implements TV {

	private Speaker speaker;
	@Override
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("AppleTV : TV를 켭니다.");
	}
	public void powerOff() {
		System.out.println("AppleTV : TV를 끕니다.");
	}
	public void channelUp() {
		System.out.println("AppleTV : 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("AppleTV : 채널을 내립니다.");
	}
	public void soundUp() {
		if (speaker == null) System.out.println("AppleTV : 소리를 키웁니다.");
		else speaker.soundUp();
	}
	public void soundDown() {
		if (speaker == null) System.out.println("AppleTV : 소리를 줄입니다.");
		else speaker.soundDown();
	}
}