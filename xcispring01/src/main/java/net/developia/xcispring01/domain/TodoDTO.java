package net.developia.xcispring01.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	//date는 항상 util로 잡기
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date dueDate;
}
