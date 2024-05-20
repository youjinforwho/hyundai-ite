package net.developia.spring01.di301e;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("net/developia/spring01/di301e/system.properties")
public class FileOutputterImpl implements FileOutputter {
	
	@Value("${fileName}")private String fileName;
	
	
	@Override
	public void output(String msg) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
	}

}
