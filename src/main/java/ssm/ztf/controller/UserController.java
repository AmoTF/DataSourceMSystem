package ssm.ztf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.ztf.model.DB;
import ssm.ztf.model.User;
import ssm.ztf.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	
	// 登录到首页
	@RequestMapping("listDB")
	public String getlistDB(HttpServletRequest request) {
		List<DB> db=userService.getDBList();
		request.setAttribute("db", db);
		return "listDB";
	}

}
