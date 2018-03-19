package ssm.ztf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.ztf.dao.UserDao;
import ssm.ztf.model.DB;
import ssm.ztf.model.User;
import ssm.ztf.service.UserService;

@Service
public class  UserServiceImpl implements UserService  {


	// 注入Service依赖
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public User login(String userName) {
		// TODO Auto-generated method stub
		
		User user=userDao.login(userName);
		return user;
	}

	@Override
	@Transactional
	public List<DB> getDBList() {
		List<DB> db=userDao.getDBList();
		return db;
	}

	@Override
	@Transactional
	public DB queryDBListId(int id) {
		DB db=userDao.queryDBListId(id);
		return db;
	}
	
	
	
	

	
}
