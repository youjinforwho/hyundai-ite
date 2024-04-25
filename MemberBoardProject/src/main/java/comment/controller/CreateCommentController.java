package comment.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import comment.service.CommentService;
import comment.vo.CommentVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class CreateCommentController
 */
@WebServlet("/comment")
public class CreateCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String commentContent = request.getParameter("commentContent");
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
      
        CommentVO comment = new CommentVO();
		comment.setComment_id(memberInfo.getMember_id());
		comment.setBoard_num(boardNum);
		comment.setComment_content(commentContent);
		comment.setComment_date(formattedDateTime);

		CommentService commentService = new CommentService();
		int result = commentService.createNewComment(comment);
		List<CommentVO> commentList = commentService.findAllComments(boardNum);
		request.setAttribute("commentList", commentList);
		
		BoardVO boardDetail = new BoardVO();
		BoardService boardService = new BoardService();
		boardDetail = boardService.viewBoardDetail(boardNum);
		request.setAttribute("boardDetail", boardDetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_detail.jsp");
		rd.forward(request, response);
	}

}
