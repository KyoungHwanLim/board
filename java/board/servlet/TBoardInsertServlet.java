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
@WebServlet("/tBoardInsert")
public class TBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TBoardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		String name=request.getParameter("name");
		service.tBoardInsert(name);
		BoardServiceInf boardService = BoardService.getInstance();
		List<BoardPageVo> bpList =boardService.tBoard();
		request.setAttribute("bpList", bpList);
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}


}
