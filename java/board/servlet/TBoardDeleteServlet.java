package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardPageVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class TBoardDeleteServlet
 */
@WebServlet("/tBoardDelete")
public class TBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TBoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		String tBoard=request.getParameter("tBoard");
		service.tBoardDelete(tBoard);
		BoardServiceInf boardService = BoardService.getInstance();
		List<BoardPageVo> bpList =boardService.tBoard();
		request.setAttribute("bpList", bpList);
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}


}
