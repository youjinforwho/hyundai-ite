package board.controller;

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

import board.vo.BoardVO;
import member.vo.MemberVO;
import board.service.BoardService;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/create")
public class BoardCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCreateController() {
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
		//1. 입력받고(Controller의 역할)
		//	 일반적으로 입력을 받아서 VO로 만들어요
		// 	 Post방식으로 한글이 전달될 때 Encoding처리를 해줘야 함
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
      
		BoardVO board = new BoardVO();
		board.setBoard_id(memberInfo.getMember_id());
		board.setBoard_subject(boardSubject);
		board.setBoard_content(boardContent);
		board.setBoard_date(formattedDateTime);
        
        //2. 로직처리해서(Service에게 위임)
		BoardService service = new BoardService();
		int result = service.createNewBoard(board);
		List<BoardVO> boardList = service.updateBoardList();
		request.setAttribute("boardList", boardList);
		
		//3. 결과 출력
		//	 서비스로부터 결과를 받아서(일반적으로 VO나 List<VO>의 형태
		//   Servlet(Controller)가 출력을 담당하지 않고
		//   View의 역할을 수행하는 JSP에게 결과데이터를 넘겨줘요
		//   JSP(View)가 클라이언트에게 결과를 출력!
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_view.jsp");
		rd.forward(request, response);

	}

}
