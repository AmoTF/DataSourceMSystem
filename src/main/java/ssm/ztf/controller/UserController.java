package ssm.ztf.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import ssm.ztf.db.dao.HDFSDao;
import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.service.UserService;
import ssm.ztf.utl.HDFS;
import ssm.ztf.utl.JsonDateValueProcessor;
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

	// 跳转到数据源列表右边
	@RequestMapping("empty")
	public String getEmpty(HttpServletRequest request) {

		return "empty";
	}

	// 根据id跳转到某个数据源页面
	@RequestMapping("indexDB/{id}")
	public String getindexDB(HttpServletRequest request, @PathVariable String id) {

		DB db = userService.queryDBListId(Integer.parseInt(id));
		request.setAttribute("id", id);

		// 判断数据源类型
		if (db.getDbType().equals("MySQL")) {
			RDBMSDao RDBMSDao = new RDBMSDao();
			List<TreeNode> list = RDBMSDao.getDB(db);
			JSONArray result = JSONArray.fromObject(list);

			request.setAttribute("result", result);

			return "indexDB";
		} else if (db.getDbType().equals("HDFS")) {
			String server = "hdfs://" + db.getServer() + ":" + db.getPort() + "/";
			List<HDFS> listFile = new ArrayList<HDFS>();

			try {
				HDFSDao HDFS = new HDFSDao(server);
				listFile = HDFS.getFilesUnderFolder("/");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("listFile", listFile);
			return "indexHDFS";
		}

		return "error";
	}

	// 显示相应数据源的表的数据
	@RequestMapping(value = "DBTableData/{id}/{tableName}", method = RequestMethod.GET)
	public String getDBTableData(HttpServletRequest request, HttpServletResponse response, @PathVariable String id,
			@PathVariable String tableName) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Set<String> colmunName = new HashSet<String>();
		DB db = new DB();
		db = userService.queryDBListId(Integer.parseInt(id));
		RDBMSDao RDBMSDao = new RDBMSDao();

		try {
			list = RDBMSDao.getDBTableData(db, tableName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
		JSONArray jr = JSONArray.fromObject(list, jsonConfig);
		request.setAttribute("jr", jr);

		Iterator iterator = jr.getJSONObject(0).keys();
		int size = 0;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			colmunName.add(key);
			size++;
		}
		JSONArray colmun = JSONArray.fromObject(colmunName);
		request.setAttribute("colmun", colmun);
		request.setAttribute("size", size);

		/*if (jr.size() > 0) {
			for (int i = 0; i < jr.size(); i++) {
				// 遍历 jsonarray 数组，把每一个对象转成 json 对象
				JSONObject job = jr.getJSONObject(i);
				// 得到 每个对象中的属性值
				System.out.println(job.get("id") + "=");
			}
		}*/

		return "indexDBTable";
	}

	// HDFS操作
	@RequestMapping(value = "HDFSOperating/{id}")
	public String HDFSOperating(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable String id) {
		
		String path=request.getParameter("path");
		String name=request.getParameter("name");
        String isDir=request.getParameter("isDir");
        
        String dir=path+name;
		DB db = userService.queryDBListId(Integer.parseInt(id));
		String server = "hdfs://" + db.getServer() + ":" + db.getPort() + "/";
		System.out.println(server);
		HDFSDao HDFS;
		try {
			HDFS = new HDFSDao(server);
			if(isDir.equals("File")){
				String content=HDFS.readFile(dir);
				request.setAttribute("content", content);
				request.setAttribute("dir", dir);
				request.setAttribute("name", name);
				return "fileContent";

			}else{
				List<HDFS> listFile = HDFS.getFilesUnderFolder(dir);
				request.setAttribute("listFile", listFile);
				return "indexHDFS";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return "error";
	}
	
	

}
