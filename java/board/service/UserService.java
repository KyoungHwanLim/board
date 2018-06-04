package board.service;

import board.dao.UserDao;
import board.dao.UserDaoInf;
import board.model.UserVo;

public class UserService implements UserServiceInf {
	
	private static UserServiceInf service;
	private UserDaoInf dao = UserDao.getInstance();
	private UserService(){
		
	}
	
	public static UserServiceInf getInstance(){
		service = new UserService();
		return service;
	}

	public UserVo loginTry(UserVo userVo) {
		return dao.loginTry(userVo);
	}
	
}
