package ssm.ztf.utl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssm.ztf.model.DB;

/**
 * @author AMO
 *
 */
public class DBConnection {

	private String dbType;
	private String dbIp;
	private int dbPort;
	private String dbInstance;
	private String dbSchema;
	private String userName;
	private String password;

	public DBConnection() {
		super();
	}

	public DBConnection(String dbType, String dbIp, int dbPort, String dbInstance, String dbSchema, String userName,
			String password) {
		super();
		this.dbType = dbType;
		this.dbIp = dbIp;
		this.dbPort = dbPort;
		this.dbSchema = dbSchema;
		this.dbInstance = dbInstance;
		this.userName = userName;
		this.password = password;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbIp() {
		return dbIp;
	}

	public void setDbIp(String dbIp) {
		this.dbIp = dbIp;
	}

	public int getDbPort() {
		return dbPort;
	}

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
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

	public String getDbInstance() {
		return dbInstance;
	}

	public void setDbInstance(String dbInstance) {
		this.dbInstance = dbInstance;
	}

	@Override
	public String toString() {
		return "DBConnection [dbType=" + dbType + ", dbIp=" + dbIp + ", dbPort=" + dbPort + ", dbInstance=" + dbInstance
				+ ", dbSchema=" + dbSchema + ", userName=" + userName + ", password=" + password + "]";
	}

	public Connection getConnection(DB db) {

		setDbType(db.getDbType());
		setDbIp(db.getServer());
		setDbPort(db.getPort());
		setDbInstance(db.getName());
		setUserName(db.getDbName());
		setPassword(db.getDbPasswd());
		String driverClass = null;
		String url = null;
		if (this.dbType.equalsIgnoreCase("mysql")) {
			driverClass = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://" + dbIp + ":" + dbPort + "/" + dbInstance;
		} else if (this.dbType.equalsIgnoreCase("oracle")) {
			driverClass = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@" + dbIp + ":" + dbPort + ":" + dbInstance;
		} else if (this.dbType.equalsIgnoreCase("post")) {
			driverClass = "org.postgresql.Driver";
			url = "jdbc:postgresql://" + dbIp + ":" + dbPort + "/" + dbInstance;
		}
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 获取数据库中所有表的表名，并添加到列表结构中。
	public List getTableNameList(Connection conn) throws SQLException {
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
		List tableNameList = new ArrayList();
		while (rs.next()) {
			tableNameList.add(rs.getString("TABLE_NAME"));
		}
		return tableNameList;
	}

	// 获取数据表中所有列的列名，并添加到列表结构中。
	public List getColumnNameList(Connection conn, String tableName) throws SQLException {
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
		List columnNameList = new ArrayList();
		while (rs.next()) {
			columnNameList.add(rs.getString("COLUMN_NAME"));
		}
		return columnNameList;
	}

	// 获取数据表中所有列的列名，并添加到列表结构中。
	public List getColumnTypeList(Connection conn, String tableName) throws SQLException {
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
		List columnNameList = new ArrayList();
		while (rs.next()) {
			columnNameList.add(rs.getString("TYPE_NAME"));
		}
		
		return columnNameList;
	}

	public List getDBTableData(Connection conn,String tableName) throws SQLException{
		
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String sql="select * from "+tableName+" limit 10";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        list=convertToList(rs);
		return list;
		
	}
	
	//rs结果集转为List类型
	public static List<Map<String, Object>> convertToList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            Map<String, Object> rowData = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
        } 
       
        return list;
    }
	
	
}
