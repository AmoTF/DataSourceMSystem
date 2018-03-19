package ssm.ztf.model;

public class DB {

	private int id;
	private String name;
	private String title;
	private String server;
	private int port;
	private String dbType;
	private String dbName;
	private String dbPasswd;
	private String dbVersion;
	private String remarks;
	private String lastDate;
	private String creater;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getServer() {
		return server;
	}
	public void setServerip(String server) {
		this.server = server;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbPasswd() {
		return dbPasswd;
	}
	public void setDbPasswd(String dbPasswd) {
		this.dbPasswd = dbPasswd;
	}
	public String getDbVersion() {
		return dbVersion;
	}
	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	@Override
	public String toString() {
		return "DB [id=" + id + ", name=" + name + ", title=" + title + ", server=" + server + ", port=" + port
				+ ", dbType=" + dbType + ", dbName=" + dbName + ", dbPasswd=" + dbPasswd + ", dbVersion=" + dbVersion
				+ ", remarks=" + remarks + ", lastDate=" + lastDate + ", creater=" + creater + "]";
	}
	
	
	

}
