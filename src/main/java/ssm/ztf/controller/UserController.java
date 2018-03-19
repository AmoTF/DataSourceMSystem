package ssm.ztf.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	// 跳转到数据源列表页面
	@RequestMapping("listDB")
	public String getlistDB(HttpServletRequest request) {
		List<DB> db = userService.getDBList();
		request.setAttribute("db", db);
		return "listDB";
	}

	// 根据id跳转到某个数据源页面
	@RequestMapping("indexDB/{id}")
	public String getindexDB(HttpServletRequest request, @PathVariable String id) {
		
		DB db= userService.queryDBListId(Integer.parseInt(id));
		RDBMSDao RDBMSDao=new RDBMSDao();
		Map<String,List> tableAndColumn=RDBMSDao.getDB(db);
		request.setAttribute("tableAndColumn", tableAndColumn);
		
		return "indexDB";
	}

	// 显示相应数据源的表结构
	@RequestMapping("indexDBTable")
	public String toindexDBTable(HttpServletRequest request) {
		
		// List<DB> db = userService.getDBList();
		// request.setAttribute("db", db);
		return "indexDBTable";
	}

}
