package net.developia.spring01.di301e;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("net/developia/spring01/di301e/system.properties")
public class OutputterImpl implements Outputter {
	@Value("${name}") private String name;
	@Value("${greeting}") private String greeting;
	@Autowired private FileOutputter fileOutputter;
	
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
