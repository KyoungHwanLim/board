package board.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class Pagination
 */
@WebServlet("/pagination")
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaginationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		
		
		String pageString = request.getParameter("page");
		int page = pageString ==null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString ==null ? 10 : Integer.parseInt(pageSizeString);
		
		String tBoard = request.getParameter("tBoard");

		Map<String, Object> resultMap = service.getBoardPageList(page, pageSize,tBoard);
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
