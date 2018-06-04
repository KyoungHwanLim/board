package board.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardPageVo;
import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardAddServlet
 */
@WebServlet("/boardAdd")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardServiceInf service = BoardService.getInstance();
		String tBoard=(String)request.getParameter("tBoard");
		List<BoardPageVo> bpList =service.tBoard();
		
		request.setAttribute("pboard_seq", request.getParameter("board_group_seq"));
		request.setAttribute("board_group_seq", request.getParameter("pboard_seq"));
		request.setAttribute("bpList", bpList);
		request.setAttribute("tBoard", tBoard);
		request.getRequestDispatcher("/boardAdd.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
