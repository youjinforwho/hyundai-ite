package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import comment.vo.CommentVO;

public class CommentDAO {

	public List<CommentVO> select(int boardNum, SqlSession session) {
		List<CommentVO> result = session.selectList("comment.findAllComments", boardNum);
		return result;
	}
	
	public CommentVO selectone(int commentNum, SqlSession session) throws Exception {
		CommentVO result = session.selectOne("comment.searchDetailComments", commentNum);
		return result;
	}
	
	public int insert(CommentVO comment, SqlSession session) {
		int result = session.insert("comment.insertNewComment", comment);
		return result;
	}

	public int update(CommentVO updateComment, SqlSession session) {
		int result = 0;
		result = session.update("comment.updateCommentContent", updateComment);
		return result;
	}

	public int delete(int commentNum, SqlSession session) {
		int result = session.delete("comment.deleteCommentContent", commentNum);
		return result;
	}
	

}
