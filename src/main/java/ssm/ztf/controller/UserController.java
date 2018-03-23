package ssm.ztf.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.service.UserService;
import ssm.ztf.utl.TreeNode;

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
		List<TreeNode> list=RDBMSDao.getDB(db);
		
		JSONArray result = JSONArray.fromObject(list);

		request.setAttribute("result", result);
		//  System.out.println(result);

		/*Iterator it = list.iterator();
		while(it.hasNext()) {
			  System.out.println(it.next());
			}*/
		return "indexDB";
	}

	// 显示相应数据源的表结构
	@RequestMapping("indexDBTable")
	public String toindexDBTable(HttpServletRequest request,String tableName) {
		
		// List<DB> db = userService.getDBList();
		// request.setAttribute("db", db);
		return "indexDBTable";
	}

}
