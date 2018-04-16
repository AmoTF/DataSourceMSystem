package ssm.ztf.db.dao;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.sqoop.Sqoop;
import org.apache.sqoop.tool.SqoopTool;
import org.apache.sqoop.util.OptionsFileUtil;

import ssm.ztf.model.DB;
import ssm.ztf.utl.OperatingHDFS;

/**
 * @author AMO
 *
 */
public class DataMigrationDao {

	
	public boolean  MysqlToHDFS(DB hdfs,String dbName,String tableName) throws Exception {
		 
		String server = "hdfs://" + hdfs.getServer() + ":" + hdfs.getPort();
	 	System.out.println(server);
	 	//lastmodified模式,添加更新，如果目录不存在，则会存储到用户目录下的_sqoop中
        String[] args = new String[] {
                "--connect","jdbc:mysql://127.0.0.1:3306/"+dbName,
                "--driver","com.mysql.jdbc.Driver",
                "--username","root",
                "--password","root",
                "--table",tableName,
                "--warehouse-dir","/"+tableName+"/",
                "-m","1"
        };
        
        String[] expandArguments = OptionsFileUtil.expandArguments(args);
        for(String i:expandArguments){
        System.out.println(i);
        }
        SqoopTool tool = SqoopTool.getTool("import");

        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://123.207.227.116:9000");//设置HDFS服务地址
       /* FileSystem fs=FileSystem.get(conf);
        OperatingHDFS.createDir("/"+tableName,fs);*/
        Configuration loadPlugins = SqoopTool.loadPlugins(conf);
        Sqoop sqoop = new Sqoop((com.cloudera.sqoop.tool.SqoopTool) tool, loadPlugins);
       
         int res=Sqoop.runSqoop(sqoop, expandArguments);
         if (res == 0){
        	 return true;
         }else{
        	 return false;
         }
        
    }

}
