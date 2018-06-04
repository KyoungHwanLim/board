package board.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BoardServiceInf service = BoardService.getInstance();
    	service.boardDelete(request.getParameter("board_seq"));
    	response.sendRedirect(request.getContextPath()+"/boardList");
    }

}
