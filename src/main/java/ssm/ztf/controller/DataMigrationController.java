package ssm.ztf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dataMigration")
public class DataMigrationController {

	// 跳转到数据迁移主页面
	@RequestMapping("index")
	public String getIndexDataMigration(HttpServletRequest request) {

		return "indexDataMigration";
	}

	// 跳转到数据迁移主页面
	@RequestMapping("MySQLToHDFS")
	public String getMySQLToHDFS(HttpServletRequest request) {

		return "MySQLToHDFS";
	}

}
