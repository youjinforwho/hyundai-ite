package net.developia.spring01.di202e;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("net/developia/spring01/di202e/system.properties")
public class OutputterImpl implements Outputter {
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;
	
	public OutputterImpl (FileOutputter fileOutputter, @Value("${name}") String name, @Value("${greeting}") String greeting) {
		this.fileOutputter = fileOutputter;
		this.name = name;
		this.greeting = greeting;
	}
	
	@Override
	public void greeting() {
		System.out.println(name + "님, " + greeting);
		try {
			if (fileOutputter != null) fileOutputter.output(name + "님, " + greeting);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
