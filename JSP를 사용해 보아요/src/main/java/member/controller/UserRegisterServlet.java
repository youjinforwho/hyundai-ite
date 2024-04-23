package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/userInput")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		//1. 입력받고
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String age = request.getParameter("userAge");
//		 클라이언트가 보내준 데이터를 받아서 VO로 생성
		MemberVO vo = new MemberVO(name, age);
		
		//이쯤에서 Session 객체를 하나 생성할 거에요!
		//만약 클라이언트에게 이전에 할당된 session이 있으면 그거 가져오고
		//만약 클라이언트에게 할당된 session이 없으면 생성하세요
		HttpSession session = request.getSession(true);
		session.setAttribute("MyDATA", vo);
		
		//2. 로직처리
		//   로직처리하기 위해서 서비스 생성해서 VO를 전달해서 로직처리
		//   Service가 결국 최종 결과물을 Controller(Servlet)에게 return
		
		//3. 출력처리
		//   Servlet(Controller)가 최종 결과물을 보고 어떤 View(JSP)를 이용해서 클라이언트에게 결과를 보여줄지 선택
		//   출력결과에 맞는 JSP를 선택해서 request를 전달해요
		
		//   해당 JSP가 적절하게 출력할 수 있도록 처리
		//	 위에서 생성한 VO를 JSP에게 전달해서 출력해볼거에요
		//	 그다음에 호출될 놈을 알려줌
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		//지정한 경로로 response와 함께 request를 넘김
		//JSP에게 데이터를 전달하려면 어떻게 해야 하나요?
		//JSP에게 전달되는 request 객체에 내가 원하는 데이터를 붙여서 전달하면 좋을거 같아요
		//맵 구조이므로 key-value 쌍으로 보내려는 데이터를 포함시켜 설정할 수 있음
//		request.setAttribute("ResultVO", vo);
		
		rd.forward(request, response);
	}

}
