package comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.vo.CommentVO;

/**
 * Servlet implementation class UpdateCommentController
 */
@WebServlet("/updatecomment")
public class UpdateCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentController() {
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
		
		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
		String commentContent = request.getParameter("commentContent");
		
		CommentVO updateComment = new CommentVO();
		CommentService commentService = new CommentService();
		
		updateComment = commentService.viewCommentDetail(commentNum);
		updateComment.setComment_content(commentContent);

		int updateCheck = commentService.updateCommentContent(updateComment);
		if (updateCheck != 0) {
			System.out.println("성공적으로 수정되었어요!");
		} else {
			System.out.println("수정 실패...");
		}
		


	}

}
