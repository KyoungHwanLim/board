package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardPageVo;
import board.model.BoardVo;
import board.model.CommentsVo;

public class BoardDao implements BoardDaoInf{
private static BoardDao dao;
	
	private SqlSessionFactory sqlSessionFactory;
	public BoardDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BoardDao getInstance(){
		dao=new BoardDao();
		return dao;
	}


	public List<BoardVo> boardList(String tBoard) {
		
		return sqlSessionFactory.openSession().selectList("boardList",tBoard);
	}




	public BoardVo boardDetail(Map<String, String> map) {
		return sqlSessionFactory.openSession().selectOne("boardDetail",map);
	}
	
	
	public List<BoardPageVo> tBoard() {
		return sqlSessionFactory.openSession().selectList("tBoard");
	}


	public Integer boardInsert(BoardVo boardVo) {
		
		
		SqlSession sqlSession =sqlSessionFactory.openSession();
		if(sqlSession.insert("boardInsert",boardVo)==1){
			sqlSession.commit();
			sqlSession.close();
			return sqlSessionFactory.openSession().selectOne("findBoardSeq");
		}else{
			sqlSession.rollback();
			sqlSession.close();
			return -1;
		}
		
	}


	public List<String> getFilename(String board_seq) {
		return sqlSessionFactory.openSession().selectList("getFilename",board_seq);
	}


	public void insertFile(HashMap<String, String> map) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.insert("insertFile", map);
		sqlSession.commit();
		sqlSession.close();
	}


	public void boardDelete(String board_seq) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.update("boardDelete",board_seq);
		sqlSession.commit();
		sqlSession.close();
	}


	
	public int getUserTotalCnt(String tBoard){
		return sqlSessionFactory.openSession().selectOne("getUserTotalCnt",tBoard);
	}


	public List<BoardVo> getBoardPageList(int page, int pageSize, String tBoard) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("page", page+"");
		paramMap.put("pageSize", pageSize+"");
		paramMap.put("tBoard", tBoard);
		
		List<BoardVo> list=sqlSessionFactory.openSession().selectList("getBoardPageList", paramMap);
		
		
		return list;
	}


	public void tBoardDelete(String tBoard) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.update("tBoardDelete", tBoard);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void tBoardUpdate(String tBoard) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.update("tBoardUpdate", tBoard);
		sqlSession.commit();
		sqlSession.close();
	}


	@Override
	public void tBoardInsert(String name) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.update("tBoardInsert", name);
		sqlSession.commit();
		sqlSession.close();
	}


	@Override
	public void addComments(CommentsVo vo) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		sqlSession.insert("addComments", vo);
		sqlSession.commit();
		sqlSession.close();
	}


	@Override
	public List<CommentsVo> readComments(String board_seq) {
		return sqlSessionFactory.openSession().selectList("readComments",board_seq);
	}
	

	
	
	
	

}
