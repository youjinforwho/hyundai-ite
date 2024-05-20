package net.developia.spring01.di101e;

public class OutputterImpl implements Outputter {
	
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;
	
//	public void setFileOutputter(FileOutputter fileOutputter) {
//		this.fileOutputter = fileOutputter;
//	}
	
	public OutputterImpl(FileOutputter fileOutputter, String name, String greeting) {
		this.fileOutputter = fileOutputter;
		this.name = name;
		this.greeting = greeting;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setGreeting(String greeting) {
//		this.greeting = greeting;
//	}
	
	@Override
	public void greeting() {
		System.out.println(name + "님, " + greeting);
		try {
			fileOutputter.output(name + "님, " + greeting);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
