package net.developia.spring01.di101e;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputterImpl implements FileOutputter {
	
	private String fileName;
	
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
