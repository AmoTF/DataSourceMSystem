package ssm.ztf.dao;

import java.util.List;

import ssm.ztf.model.DB;
import ssm.ztf.model.User;

public interface UserDao {

	// 用户登录验证
	public User login(String userName);

	// 查询所有数据源
	public List<DB> getDBList();

	// 通过Id查询数据源
	public DB queryDBListId(int id);
	
	//获得所有的关系型数据库
	public List<DB> queryAllDB();
}
