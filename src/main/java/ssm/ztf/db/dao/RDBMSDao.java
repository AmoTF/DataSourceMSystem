package ssm.ztf.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ssm.ztf.model.DB;
import ssm.ztf.utl.DBConnection;
import ssm.ztf.utl.TreeNode;

/**
 * @author AMO
 *
 */
public class RDBMSDao {

	public List<TreeNode> getDB(DB db) {

		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(db);

		List<TreeNode> list = new ArrayList<TreeNode>();
		try {
			int id_1 = 1;

			List tableList = dbConn.getTableNameList(conn);
			for (int i = 0; i < tableList.size(); i++) {
				String tableName = (String) tableList.get(i);
				TreeNode treeNode = new TreeNode();
				treeNode.setId(id_1);
				treeNode.setpId(0);
				treeNode.setName(tableName);
				list.add(treeNode);

				List columnList = dbConn.getColumnNameList(conn, tableName);
				List columnTypeList = dbConn.getColumnTypeList(conn, tableName);
				int id_2 = id_1 * 100 + 1;
				int id_3 = id_1 * 1000 + 1;
				for (int j = 0; j < columnList.size(); j++) {
					String coulumnName = (String) columnList.get(j);
					TreeNode treeNode1 = new TreeNode();
					treeNode1.setId(id_2);
					treeNode1.setpId(id_1);
					treeNode1.setName(coulumnName);
					list.add(treeNode1);

					String coulumnType = (String) columnTypeList.get(j);
					TreeNode treeNodel2 = new TreeNode();
					treeNodel2.setId(id_3);
					treeNodel2.setpId(id_2);
					treeNodel2.setName(coulumnType);
					list.add(treeNodel2);

					id_2++;
					id_3++;

				}
				id_1++;

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
		return list;

	}

	public List<Map<String, Object>> getDBTableData(DB db, String tableName) throws SQLException {

		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(db);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = dbConn.getDBTableData(conn, tableName);

		// System.out.println(list);
		return list;

	}

	public List<TreeNode> getAllGDB(List<DB> list) {

		List<TreeNode> treeDB = new ArrayList<TreeNode>();
		DBConnection dbConn = new DBConnection();
		Iterator it = list.iterator();
		int id_1 = 1;

		while (it.hasNext()) {
			DB db = (DB) it.next();
			TreeNode treeNode = new TreeNode();
			treeNode.setId(id_1);
			treeNode.setpId(0);
			treeNode.setName(db.getName());
			treeDB.add(treeNode);
			Connection conn = dbConn.getConnection(db);
			try {
				List tableList = dbConn.getTableNameList(conn);
				int id_2 = id_1 * 100 + 1;
				for (int i = 0; i < tableList.size(); i++) {
					String tableName = (String) tableList.get(i);
					TreeNode tableNode = new TreeNode();
					tableNode.setId(id_2);
					tableNode.setpId(id_1);
					tableNode.setName(tableName);
					treeDB.add(tableNode);
					id_2++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id_1++;
		}
		return treeDB;
	}

}
