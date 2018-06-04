package board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.model.BoardVo;
import board.model.FileVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardInsertServlet
 */
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5 )
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAT_PATH="D:/A_TeachingMaterial/7.JspSpring/uploadStorege";
       
    public BoardInsertServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String category_seq=request.getParameter("tBoard");
		String board_title=request.getParameter("board_title");
		String board_content=request.getParameter("board_content");
		String board_group_seq=request.getParameter("board_group_seq");
		String pboard_seq=request.getParameter("pboard_seq");
		
		String board_mem_id=(String)request.getSession().getAttribute("sessionId");
		//디비로 boardVo한번보내고 boardseq나온거랑 tBoard같이 해서 file객체만들어서 저장!!!!!
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_group_seq(board_group_seq);
		boardVo.setPboard_seq(pboard_seq);
		boardVo.setBoard_mem_id(board_mem_id);
		boardVo.setBoard_content(board_content);
		boardVo.setCategory_seq(category_seq);
		boardVo.setBoard_title(board_title);
		
		
		BoardServiceInf service = BoardService.getInstance();
		int check=service.boardInsert(boardVo);
		
		if(check==-1){
			//실패하면어디루갈까요
		}else{
			//성공하면어디루?
			Part profilePart = request.getPart("file_path");
			System.out.println("++++++++++++++++++++++++++++++++++++================++++++++++++++++++++");
			System.out.println(UUID.randomUUID().toString());
			String filePath=null;
			if(profilePart.getSize()>0){
				Map<String, String> map = new HashMap<String, String>();
				String filename = UUID.randomUUID().toString();
				map.put("file_path", filename);
				map.put("board_seq", check+"");
				service.insertFile((HashMap<String, String>) map);
				filePath=UPLOAT_PATH+File.separator+filename;
				profilePart.write(filePath);//"fileName: path/+파일이름"
				profilePart.delete();
			}
			
		}
		
		response.sendRedirect(request.getContextPath()+"/boardList");
		
		
	}

}
