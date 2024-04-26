package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class BoardContentUpdateController
 */
@WebServlet("/update")
public class BoardContentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardContentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		
		BoardVO boardDetail = new BoardVO();
		BoardService service = new BoardService();
		
		boardDetail = service.viewBoardDetail(boardNum);
		boardDetail.setBoard_subject(boardSubject);
		boardDetail.setBoard_content(boardContent);

		int updateCheck = service.updateBoardContent(boardDetail);
		if (updateCheck != 0) {
			System.out.println("성공적으로 수정되었어요!");
		} else {
			System.out.println("수정 실패 ...");
		}
		request.setAttribute("boardDetail", boardDetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_detail.jsp");
		rd.forward(request, response);
		response.sendRedirect(request.getContextPath() + "/board/board_detail.jsp?boardDetail=" + boardNum);
	}

}
