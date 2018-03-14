package ssm.ztf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.ztf.dao.UserDao;
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
	
	
	
	

	
}
