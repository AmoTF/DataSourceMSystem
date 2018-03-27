package ssm.ztf.db.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import ssm.ztf.utl.HDFS;

public class HDFSDao {

	Configuration conf;
	FileSystem hdfs;

	public HDFSDao() {
	}

	public HDFSDao(String fsDefaultName) throws IOException {

		conf = new Configuration();
		conf.set("fs.default.name", fsDefaultName);
		hdfs = FileSystem.get(conf);
		// 以下两行是支持 hdfs的追加 功能的：hdfs.append()
		conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
		conf.set("dfs.client.block.write.replace-datanode-on-failure.enable", "true");
	}

	// 查看路径下所有目录
	public List<HDFS> getFilesUnderFolder(String dst) throws IOException {
		Path dstPath = new Path(dst);
		List<FileStatus> listFile1 = new ArrayList<FileStatus>();
		List<HDFS> listFile = new ArrayList<HDFS>();

		FileStatus[] file = hdfs.listStatus(dstPath);
		for (FileStatus fileStatus : file) {

			HDFS hdfs = new HDFS();
			String path = fileStatus.getPath().toString();
			String name = path.substring(path.lastIndexOf("/") + 1);
			hdfs.setPermission(fileStatus.getPermission());
			hdfs.setBlockReplication(fileStatus.getReplication());
			hdfs.setBlockSize(fileStatus.getBlockSize()/1024/1024);
			hdfs.setGroup(fileStatus.getGroup());
			hdfs.setOwner(fileStatus.getOwner());
			hdfs.setLength(fileStatus.getLen());
			hdfs.setModificationTime(new Timestamp(fileStatus.getModificationTime()));
			hdfs.setName(name);
			hdfs.setPath(path.substring(27, path.lastIndexOf("/")+1));
			if (fileStatus.isDirectory())
				hdfs.setIsDir("Folder");
			else
				hdfs.setIsDir("File");
			listFile.add(hdfs);
		}
		hdfs.close();
		// System.out.println(listFile);
		return listFile;

	}

	// 上传本地文件
	public void uploadFile(String src, String dst) throws IOException {

		Path srcPath = new Path(src); // 原路径
		Path dstPath = new Path(dst); // 目标路径
		// 调用文件系统的文件复制函数,前面参数是指是否删除原文件，true为删除，默认为false
		hdfs.copyFromLocalFile(false, srcPath, dstPath);

		// 打印文件路径
		System.out.println("Upload to " + conf.get("fs.default.name"));
		System.out.println("------------list files------------" + "\n");
		FileStatus[] fileStatus = hdfs.listStatus(dstPath);
		for (FileStatus file : fileStatus) {
			System.out.println(file.getPath());
		}
		hdfs.close();
	}

	// 创建hdfs目录
	public void createDir(String dir) throws IOException {

		Path path = new Path(dir);
		if (hdfs.exists(path)) {
			System.out.println("dir \t" + conf.get("fs.default.name") + dir + "\t already exists");
			return;
		}
		hdfs.mkdirs(path);
		System.out.println("new dir \t" + conf.get("fs.default.name") + dir);
	}

	// 从HDFS 下载文件 到本地
	@Test
	public void downloadFile(String hdfsDst, String localSrc) throws IllegalArgumentException, IOException {

		Path dst = new Path(hdfsDst);
		Path src = new Path(localSrc);
		// 本地的路径 + hdfs下载的文件名
		String localFile = localSrc + "/" + dst.getName();
		// 如果HDFS路径不存在
		if (!hdfs.exists(dst.getParent())) {
			System.out
					.println("Error : the HDFS directory:\t" + dst.getParent() + "\tdoes not exist. Please check it!");
			return;
		}
		// 如果本地目录不存在，则创建
		if (!new File(localSrc).exists()) {
			new File(localSrc).mkdirs();
			System.out.println("Warn : The local directory does not exist. It has been automatically created for you!");
		}
		// 如果本地文件存在
		if (new File(localFile).exists()) {
			System.out.println("Error : the localSrc: \t" + localFile + "\t already exists.");
			return;
		}
		// 如果HDFS文件不存在
		if (!hdfs.exists(new Path(hdfsDst))) {
			System.out.println("Error : the HDFS file: \t" + hdfsDst + "\t not exists.");
		} else {
			// HDFS下载文件到本地
			hdfs.copyToLocalFile(false, dst, src, true);
			System.out.println("successful ：download successful! please look at: \t" + localSrc);
		}
	}

	// 读取文件
	public void readFile(String uri) throws IOException {

		// 判断文件是否存在
		if (!hdfs.exists(new Path(uri))) {
			System.out.println("Error ; the file not exists.");
			return;
		}
		InputStream in = null;
		try {
			in = hdfs.open(new Path(uri));
			BufferedReader bf = new BufferedReader(new InputStreamReader(in, "GB2312"));// 防止中文乱码
			// 复制到标准输出流
			IOUtils.copyBytes(in, System.out, 4096, false);
			/*String line = null;
			while((line = bf.readLine()) != null){
			    System.out.println(line);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(in);
		}
	}

	// 文件重命名
	public void renameFile(String oldName, String newName) throws IOException {

		Path oldPath = new Path(oldName);
		Path newPath = new Path(newName);
		if (hdfs.exists(oldPath)) {
			hdfs.rename(oldPath, newPath);
			System.out.println("重命名成功！");
		} else {
			System.out.println("文件不存在!rename失败!");
		}
	}

	// 判断文件是否存在，存在即删除
	public void deleteFile(String fileName) throws IOException {

		Path f = new Path(fileName);
		boolean isExists = hdfs.exists(f);
		if (isExists) { // if exists, delete
			boolean isDel = hdfs.delete(f, true);
			System.out.println(fileName + "  delete? \t" + isDel);
		} else {
			System.out.println(fileName + "  exist? \t" + "notExists");
		}
	}

	public static void main(String[] args) throws IOException {
		HDFSDao o = new HDFSDao("hdfs://123.207.227.116:9000/");

		try {
			// o.uploadFile("D:\\bigdata\\test1.txt", "/test2");
			// o.createDir("/test2/");
			// o.downloadFile("/wmj/user_label.txt", "D:/hadfs");
			// o.deleteFile("/test2");
			// o.readFile("/test2");
			// o.renameFile("/test2/test1.txt", "/test2/test2.txt");
			o.getFilesUnderFolder("/bigdata");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
