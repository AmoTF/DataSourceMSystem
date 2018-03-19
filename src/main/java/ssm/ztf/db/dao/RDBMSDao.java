package ssm.ztf.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssm.ztf.model.DB;
import ssm.ztf.utl.DBConnection;

/**
 * @author AMO
 *
 */
public class RDBMSDao {

	
	public Map<String,List> getDB(DB db){
		
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(db);
		Map<String,List> tableAndColumn = new HashMap<String,List>();
		
		try {
			List tableList = dbConn.getTableNameList(conn);
			for (int i = 0; i < tableList.size(); i++) {
				String tableName = (String) tableList.get(i);
				List columnList = dbConn.getColumnNameList(conn, tableName);
				tableAndColumn.put(tableName,columnList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  tableAndColumn;

	}		
	
}
