package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.BoardPageVo;
import board.model.BoardVo;
import board.model.CommentsVo;

public interface BoardDaoInf {
	public List<BoardVo> boardList(String tBoard);
	
	public BoardVo boardDetail(Map<String, String> map);
	
	public List<BoardPageVo> tBoard();
	
	public Integer boardInsert(BoardVo boardVo);
	
	public List<String> getFilename(String board_seq);
	
	public void insertFile(HashMap<String, String> map);
	
	public void tBoardDelete(String tBoard);
	
	public void boardDelete(String board_seq);
	
	public List<BoardVo> getBoardPageList(int page, int pageSize,String tBoard);
	
	public int getUserTotalCnt(String tBoard);
	
	public void tBoardUpdate(String tBoard);
	
	public void tBoardInsert(String name);

	public void addComments(CommentsVo vo);
	
	public List<CommentsVo> readComments(String board_seq);

}
