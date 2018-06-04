package board.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.UserVo;

public class UserDao implements UserDaoInf{
	
	private static UserDaoInf dao;
	
	private SqlSessionFactory sqlSessionFactory;
	public UserDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static UserDaoInf getInstance(){
		dao=new UserDao();
		return dao;
	}

	public UserVo loginTry(UserVo userVo) {
		return sqlSessionFactory.openSession().selectOne("user.loginTry",userVo);
	}
	
	
	
	
	
}
