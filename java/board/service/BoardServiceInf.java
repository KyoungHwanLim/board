package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.BoardPageVo;
import board.model.BoardVo;
import board.model.CommentsVo;

public interface BoardServiceInf {
	public List<BoardVo> boardList(String tBoard);
	
	public BoardVo boardDetail(Map<String, String> map);
	
	public List<BoardPageVo> tBoard();
	
	public Integer boardInsert(BoardVo boardVo);
	
	public List<String> getFilename(String board_seq);
	
	public void insertFile(HashMap<String, String> map);
	
	public void boardDelete(String board_seq);
	
	public Map<String, Object> getBoardPageList(int page, int pageSize, String tBoard);
	
	public void tBoardDelete(String tBoard);

	public void tBoardUpdate(String tBoard);
	
	public void tBoardInsert(String name);
	
	public void addComments(CommentsVo vo);
	
	public List<CommentsVo> readComments(String board_seq);
}
