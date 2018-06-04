package board.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardPageVo;
import board.model.BoardVo;
import board.model.CommentsVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public BoardDetailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		String board_seq=request.getParameter("board_seq");
		String tBoard= request.getParameter("tBoard");
		List<CommentsVo>commentsList= service.readComments(board_seq);
		request.setAttribute("commentsList", commentsList);
		map.put("board_seq",board_seq);
		map.put("tBoard",tBoard );
		BoardVo vo=service.boardDetail(map);
		List<String> list= service.getFilename(vo.getBoard_seq());
		request.setAttribute("list", list);
		request.setAttribute("tBoard", request.getParameter("tBoard"));
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/boardDetail.jsp").forward(request, response);
	}

}
