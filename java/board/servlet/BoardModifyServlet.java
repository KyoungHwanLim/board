package board.servlet;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/boardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		List<BoardPageVo> bpList =service.tBoard();
		request.setAttribute("bpList", bpList);
		Map<String, String>map = new HashMap<String, String>();
		map.put("board_seq", request.getParameter("board_seq"));
		map.put("tBoard", request.getParameter("tBoard"));
		BoardVo vo=service.boardDetail(map);
		List<String> list= service.getFilename(request.getParameter("board_seq"));
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/boardModify.jsp").forward(request, response);
	}

}
