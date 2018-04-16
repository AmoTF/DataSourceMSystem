package ssm.ztf.utl;

import java.io.File;

import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.Sqoop;
import org.apache.sqoop.tool.SqoopTool;
import org.apache.sqoop.util.OptionsFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

public class SqoopTest {

	//  private final static Logger log = LoggerFactory.getLogger(SqoopTest.class);

	 public boolean   importDataFromMysql() throws Exception {
		 
		 String curClasspath = System.getProperty ("java.class.path");
		 
         curClasspath = curClasspath
                        + File.pathSeparator
                        + "/var/www/webapps/***/WEB-INF/lib/hadoop-common-2.7.5.jar"
                        + File.pathSeparator
                        + "/var/www/webapps/***/WEB-INF/lib/hadoop-mapreduce-client-core-2.6.0-cdh5.5.2.jar";
		
		 	String database="bigdata";
		 	String table ="bigdata";
		 	
		 	//lastmodified模式,添加更新，如果目录不存在，则会存储到用户目录下的_sqoop中
	        String[] args = new String[] {
	                "--connect","jdbc:mysql://127.0.0.1:3306/"+database,
	                "--driver","com.mysql.jdbc.Driver",
	                "--username","root",
	                "--password","root",
	                "--table",table,
	                "--warehouse-dir","/"+table+"/",
	               
	               /*"--check-column","last_mod_ts",
	                "--incremental","lastmodified",
	                "--last-value","2018-01-18 20:46:49",
	                "--merge-key","class_id",*/
	                "-m","1"
	        };
	        
	       
	        
	        //append模式,会有多个块
	        /*String[] args = new String[] {
	                "--connect","jdbc:mysql://127.0.0.1:3306/bigdata",
	                "--driver","com.mysql.jdbc.Driver",
	                "--username","root",
	                "--password","root",
	                "--table","bigdata",
	               // "--warehouse-dir","/",
	                "--check-column","id",
	                "--incremental","append",
	                "--last-value","7",
	                "-m","1"                 
	        };*/
	        
	        String[] expandArguments = OptionsFileUtil.expandArguments(args);
	        
	        SqoopTool tool = SqoopTool.getTool("import");

	        Configuration conf = new Configuration();
	        conf.set("fs.default.name", "hdfs://123.207.227.116:9000");//设置HDFS服务地址
	        Configuration loadPlugins = SqoopTool.loadPlugins(conf);
	        Sqoop sqoop = new Sqoop((com.cloudera.sqoop.tool.SqoopTool) tool, loadPlugins);
	       
	         int res=Sqoop.runSqoop(sqoop, expandArguments);
	         if (res == 0){
	        	 return true;
	         }else{
	        	 return false;
	         }
	        
	    }
	 
	 public boolean   exportDataToMysql() throws Exception {
		 	
		 	//输出到哪个数据库的哪个表
		  	String database="bigdata";
		 	String table ="bigdata1";
		 	String exportPath="/bigdata/bigdata/";
		 	
		 	//更新操作
	        String[] args = new String[] {
	                "--connect","jdbc:mysql://127.0.0.1:3306/"+database,
	                "--driver","com.mysql.jdbc.Driver",
	                "--username","root",
	                "--password","root",
	                "--table",table,
	                "--export-dir",exportPath,     
	                "--update-key","class_id",
	                "--update-mode","updateonly",
	            
	                "-m","1"
	                          
	        };
	        String[] expandArguments = OptionsFileUtil.expandArguments(args);
	        
	        
	        SqoopTool tool = SqoopTool.getTool("export");

	        Configuration conf = new Configuration();
	        conf.set("fs.default.name", "hdfs://123.207.227.116:9000");//设置HDFS服务地址
	        Configuration loadPlugins = SqoopTool.loadPlugins(conf);
	        Sqoop sqoop = new Sqoop((com.cloudera.sqoop.tool.SqoopTool) tool, loadPlugins);
	       
	        int res = Sqoop.runSqoop(sqoop, expandArguments);
	        
	        if (res == 0){
	        	 return true;
	         }else{
	        	 return false;
	         }
	        
	    }

	    public static void main(String[] args) throws Exception {
	    	SqoopTest s=new SqoopTest();
	    	System.out.println(s.importDataFromMysql());
	    	//System.out.println(s.exportDataToMysql());
	    }
}
