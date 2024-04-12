package booksearch.service;

import booksearch.VO.BookVO;
import booksearch.dao.BookDAO;
import javafx.collections.ObservableList;

public class BookSearchService {
	//로직처리 객체
	//당연히 이 안에는 business method가 존재함
	
	public ObservableList<BookVO> searchBookByKeyWord(String keyword) {
		//이 안에서는 로직처리를 하면 됨
		//만약 Database 처리를 하게 되면 DAO를 만들어서 사용해야 됨
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> result = dao.select(keyword);

		return result;
	}
	
	public void deleteBookByCliked(BookVO selectedItem) {
		BookDAO dao = new BookDAO();
		dao.delete(selectedItem);
	}
	

}
