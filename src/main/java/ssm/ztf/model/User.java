package ssm.ztf.model;

import org.apache.ibatis.type.Alias;

/**
 * 学生
 */
@Alias("User")
public class User {

	// ID
	private int id;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 角色
	private int role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
