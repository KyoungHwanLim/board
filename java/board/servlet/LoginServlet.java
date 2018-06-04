package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import board.model.BoardPageVo;
import board.model.UserVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import board.service.UserService;
import board.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("userId");
		String mem_pass = request.getParameter("userPass");
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", mem_id);
		
		UserVo userVo=new UserVo();
		userVo.setMem_id(mem_id);
		userVo.setMem_pass(mem_pass);
		
		UserServiceInf service = UserService.getInstance();
		UserVo vo = service.loginTry(userVo);
		if(vo!=null&&mem_id.equals("admin")){
			
			BoardServiceInf boardService = BoardService.getInstance();
			List<BoardPageVo> bpList =boardService.tBoard();
			request.setAttribute("bpList", bpList);

			
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");//관리페이지로이동
			rd.forward(request, response);
		}else if(vo!=null){
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("/boardList");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
