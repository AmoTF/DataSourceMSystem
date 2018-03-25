package ssm.ztf.test.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.model.User;
import ssm.ztf.service.UserService;
import ssm.ztf.test.BaseTest;
import ssm.ztf.utl.JsonDateValueProcessor;

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
		List<DB> db = userService.getDBList();
		System.out.println(db);
	}

	@Test
	public void testQueryDBListId() throws Exception {
		int id = 1;
		DB db = userService.queryDBListId(id);
		RDBMSDao RDBMSDao = new RDBMSDao();
		RDBMSDao.getDB(db);

	}

	@Test
	public void testGetDBTableData() throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int id = 1;
		DB db = userService.queryDBListId(id);
		RDBMSDao RDBMSDao = new RDBMSDao();
		list = RDBMSDao.getDBTableData(db, "bigdata");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
		JSONArray jr = JSONArray.fromObject(list, jsonConfig);

		Iterator iterator = jr.getJSONObject(0).keys();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key);
			String value = jr.getJSONObject(0).getString(key);
		}

	}

}
