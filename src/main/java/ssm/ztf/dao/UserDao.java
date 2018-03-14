package ssm.ztf.dao;

import ssm.ztf.model.User;

public interface  UserDao {

	//用户登录验证
	public User login(String userName);

}
