package net.developia.persistence;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import net.developia.domain.Criteria;
import net.developia.domain.ReplyVO;
import net.developia.mapper.ReplyMapper;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@Log4j
public class ReplyMapperTests {
	private Long[] bnoArr = {1L, 4L, 5L, 6L, 10L};
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void Create() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			//게시물 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	@Test
	public void testRead() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 2L;
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate() {
		Long targetRno = 3L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply ");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 2228242L );
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}





