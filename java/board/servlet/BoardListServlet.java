package board.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		String tBoard=(String)request.getParameter("tBoard");
		List<BoardPageVo> bpList =service.tBoard();
		request.setAttribute("bpList", bpList);
		if(tBoard==null){
			
			request.setAttribute("tBoard", tBoard);
			
			String pageString = request.getParameter("page");
			int page = pageString ==null ? 1 : Integer.parseInt(pageString);
			
			String pageSizeString = request.getParameter("pageSize");
			int pageSize = pageSizeString ==null ? 10 : Integer.parseInt(pageSizeString);
			
			Map<String, Object> resultMap = service.getBoardPageList(page, pageSize,"1");
			request.setAttribute("boardList", resultMap.get("boardList"));
			request.setAttribute("pageNav", resultMap.get("pageNav"));
			
			request.getRequestDispatcher("/boardList.jsp").forward(request, response);
			
		}else{
			String pageString = request.getParameter("page");
			int page = pageString ==null ? 1 : Integer.parseInt(pageString);
			
			String pageSizeString = request.getParameter("pageSize");
			int pageSize = pageSizeString ==null ? 10 : Integer.parseInt(pageSizeString);
			
			Map<String, Object> resultMap = service.getBoardPageList(page, pageSize,tBoard);
			request.setAttribute("boardList", resultMap.get("boardList"));
			request.setAttribute("pageNav", resultMap.get("pageNav"));
			
			request.setAttribute("tBoard", tBoard);
			request.getRequestDispatcher("/boardList.jsp").forward(request, response);
		}
	}

}
