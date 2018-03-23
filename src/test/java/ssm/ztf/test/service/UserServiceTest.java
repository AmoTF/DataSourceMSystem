package ssm.ztf.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.model.User;
import ssm.ztf.service.UserService;
import ssm.ztf.test.BaseTest;

public class UserServiceTest extends BaseTest {

	@Autowired
	UserService userService;

	@Test
	public void testlogin() throws Exception {
		String userName = "admin";
		User user = userService.login(userName);
		System.out.println(user);
	}
	
	@Test
	public void testGetDBList() throws Exception {
		List<DB> db= userService.getDBList();
		System.out.println(db);
	}
	
	@Test
	public void testQueryDBListId() throws Exception {
		int id=1;
		DB db= userService.queryDBListId(id);
		RDBMSDao RDBMSDao=new RDBMSDao();
		RDBMSDao.getDB(db);
		
	}
	
	@Test
	public void testGetDBTableData() throws Exception {
		int id=1;
		DB db= userService.queryDBListId(id);
		RDBMSDao RDBMSDao=new RDBMSDao();
		RDBMSDao.getDBTableData(db,"bigdata");
		
	}
	

}
