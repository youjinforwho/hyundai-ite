package net.developia.xcispring01.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT to_char(sysdate, 'YYYY-mm-dd') FROM dual")
	public String getTime();
	
	public String getTime2();
}
