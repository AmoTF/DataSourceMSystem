package ssm.ztf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ssm.ztf.db.dao.DataMigrationDao;
import ssm.ztf.db.dao.RDBMSDao;
import ssm.ztf.model.DB;
import ssm.ztf.service.UserService;
import ssm.ztf.utl.SplicingSQL;
import ssm.ztf.utl.SqoopTest;
import ssm.ztf.utl.TreeNode;

@Controller
@RequestMapping("/dataMigration")
public class DataMigrationController {

	@Autowired
	UserService userService;
	
	 private final static Logger log = LoggerFactory.getLogger(SqoopTest.class);
	
	// 跳转到数据迁移主页面
	@RequestMapping("index")
	public String getIndexDataMigration(HttpServletRequest request) {

		return "indexDataMigration";
	}

	// 跳转到数据迁移主页面
	@RequestMapping("MySQLToHDFS")
	public String getMySQLToHDFS(HttpServletRequest request) {
		
		List<DB> list=new ArrayList<DB>(); 
		list=userService.queryAllDB();
		
		RDBMSDao RDBMSDao = new RDBMSDao();
		List<TreeNode> GDB =RDBMSDao.getAllGDB(list);
		JSONArray AllGDB = JSONArray.fromObject(GDB);

		request.setAttribute("AllGDB", AllGDB);
		return "MySQLToHDFS";
	}
	
		// mysql->hdfs
		@RequestMapping("dataMySQLToHDFS")
		public String dataMySQLToHDFS(HttpServletRequest request) {
			
			String data = SplicingSQL.readJSONString(request);
			JSONObject o = JSONObject.fromObject(data);
			
			String inputSource =o.getString("inputSource");
			String exportSource=o.getString("exportSource");
			String hdfsId=o.getString("hdfsId");
			
			String[] str = inputSource.split(":");
			String dbName=str[0];
			String tableName=str[1];

			DB hdfs = userService.queryDBListId(Integer.parseInt(hdfsId));
			DataMigrationDao dataMigrationDao=new DataMigrationDao();
			try {
				//Boolean result=dataMigrationDao.MysqlToHDFS(hdfs, dbName, tableName);
				SqoopTest sqoop=new SqoopTest();
				sqoop.importDataFromMysql();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "MySQLToHDFS";
		}

}
