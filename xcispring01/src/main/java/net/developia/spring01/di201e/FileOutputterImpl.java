package net.developia.spring01.di201e;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("net/developia/spring01/di201e/system.properties")
public class FileOutputterImpl implements FileOutputter {
	
	@Value("${fileName}")private String fileName;
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void output(String msg) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
	}

}
