package ssm.ztf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.ztf.model.User;
import ssm.ztf.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserService userService;

	// 跳转到登录页面
	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	// 登录验证，ajax
	@RequestMapping("/loginValidate")
	public void login(String userName, String password, HttpServletResponse response) throws IOException {

		User user = userService.login(userName);

		PrintWriter out;

		if (user != null) {
			if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
				try {
					out = response.getWriter();
					out.print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				try {
					out = response.getWriter();
					out.print("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println(111);
			try {
				out = response.getWriter();
				out.print("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 登录到首页
	@RequestMapping("index")
	public String index() {
		return "index";
	}

}
