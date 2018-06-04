package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardPageVo;
import board.model.BoardVo;
import board.model.CommentsVo;

public class BoardService implements BoardServiceInf{
	private static BoardServiceInf service;
	private BoardDaoInf dao = BoardDao.getInstance();
	private BoardService(){
		
	}
	
	public static BoardServiceInf getInstance(){
		service = new BoardService();
		return service;
	}

	public List<BoardVo> boardList(String tBoard) {
		return dao.boardList(tBoard);
	}

	public BoardVo boardDetail(Map<String, String> map) {
		return dao.boardDetail(map);
	}

	public List<BoardPageVo> tBoard() {
		return dao.tBoard();
	}

	public Integer boardInsert(BoardVo boardVo) {
		return dao.boardInsert(boardVo);
	}

	public List<String> getFilename(String board_seq) {
		return dao.getFilename(board_seq);
	}

	public void insertFile(HashMap<String, String> map) {
		dao.insertFile(map);
	}

	public void boardDelete(String board_seq) {
		dao.boardDelete(board_seq);
	}

	public Map<String, Object> getBoardPageList(int page, int pageSize, String tBoard) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVo> list = dao.getBoardPageList(page, pageSize, tBoard);
		int userTotalCnt = dao.getUserTotalCnt(tBoard);

		String pageNav=makePageNav(page, userTotalCnt,tBoard);
		
		resultMap.put("boardList", list);
		resultMap.put("pageNav", pageNav);
		
		
		
		return resultMap;
	}
	
	private String makePageNav(int page, int userTotalCnt,String tBoard) {
		
		
		double pageTotalCnt=(int)Math.ceil(userTotalCnt / 10d);
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");		
		pageNav.append("  <ul class=\"pagination\">");		
		if(page==1){
			
			pageNav.append("    <li>");		
			pageNav.append("        <span aria-hidden=\"true\">&laquo;</span>");		
			pageNav.append("    </li>");	
		}else{
			pageNav.append("    <li>");		
			pageNav.append("      <a href='/board/boardList?page=1&pageSize=10&tBoard="+tBoard+"'>");		
			pageNav.append("        <span aria-hidden=\"true\">&laquo;</span>");		
			pageNav.append("      </a>");		
			pageNav.append("    </li>");	
			
		}
		if(page==1){
			pageNav.append("    <li>");		
			pageNav.append("        <span aria-hidden=\"true\">이전</span>");		
			pageNav.append("    </li>");		
		}else{
			pageNav.append("    <li>");		
			pageNav.append("      <a href='/board/boardList?page="+(page-1)+"&pageSize=10&tBoard="+tBoard+"'>");		
			pageNav.append("        <span aria-hidden=\"true\">이전</span>");		
			pageNav.append("      </a>");		
			pageNav.append("    </li>");		
		}
		
		for(int i=0;i<pageTotalCnt;i++){
			if(page==1){
				
			}else if(page==pageTotalCnt){
				
			}
			pageNav.append("    <li><a href='/board/boardList?page="+(i+1)+"&pageSize=10&tBoard="+tBoard+"'>"+(i+1)+"</a></li>");
		}
		if(page==(int)pageTotalCnt){
			pageNav.append("    <li>");		
			pageNav.append(" <span aria-hidden=\"true\">다음</span>");		
			pageNav.append(" </li>");		
		}else{
			pageNav.append("    <li>");		
			pageNav.append("      <a href='/board/boardList?page="+(page+1)+"&pageSize=10&tBoard="+tBoard+"'>");		
			pageNav.append(" <span aria-hidden=\"true\">다음</span>");		
			pageNav.append("   </a>");		
			pageNav.append(" </li>");		
			
		}
		if(page==(int)pageTotalCnt){
			pageNav.append("    <li>");		
			pageNav.append(" <span aria-hidden=\"true\">&raquo;</span>");		
			pageNav.append(" </li>");		
		}else{
			pageNav.append("    <li>");		
			pageNav.append("      <a href='/board/boardList?page="+(int)pageTotalCnt+"&pageSize=10&tBoard="+tBoard+"'>");		
			pageNav.append(" <span aria-hidden=\"true\">&raquo;</span>");		
			pageNav.append("   </a>");		
			pageNav.append(" </li>");		
		}
		pageNav.append("  </ul>");		
		pageNav.append("</nav>");		
		
		return pageNav.toString();
	}

	public void tBoardDelete(String tBoard) {
		dao.tBoardDelete(tBoard);
	}

	public void tBoardUpdate(String tBoard) {
		dao.tBoardUpdate(tBoard);
	}

	@Override
	public void tBoardInsert(String name) {
		dao.tBoardInsert(name);
	}

	@Override
	public void addComments(CommentsVo vo) {
		dao.addComments(vo);
	}

	@Override
	public List<CommentsVo> readComments(String board_seq) {
		return dao.readComments(board_seq);
	}

	


		
}
