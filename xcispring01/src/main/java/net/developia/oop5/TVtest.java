package net.developia.oop5;

import java.io.FileInputStream;
import java.util.Properties;

public class TVtest {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("product.properties"));
		String tvName = props.getProperty("tv");
		String SpeakerName = props.getProperty("speaker");
		//해당 이름을 가진 클래스가 있는지 확인
		Class tvClass = Class.forName(tvName);
		Class speakerClass = Class.forName(SpeakerName);
		
		Speaker speaker = (Speaker) speakerClass.getConstructor().newInstance();
		TV tv = (TV) tvClass.getConstructor().newInstance(); //new AppleTV();
		tv.setSpeaker(speaker);
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.powerOff();
	}
}

// AppleTV에서 MarshallSpeaker
