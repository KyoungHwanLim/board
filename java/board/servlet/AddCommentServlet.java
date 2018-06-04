package board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.CommentsVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_seq=request.getParameter("board_seq"); 
		String tBoard=request.getParameter("tBoard"); 
		String sessionId=(String) request.getSession().getAttribute("sessionId");
		String comments=request.getParameter("comments"); 
		BoardServiceInf service = BoardService.getInstance();
		service.addComments(new CommentsVo(board_seq,sessionId,comments));
		request.getRequestDispatcher("/boardDetail?").forward(request, response);
	}


}
