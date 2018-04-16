package ssm.ztf.utl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class OperatingHDFS {
	
	OperatingHDFS() {
	}

	// 上传本地文件
	public static void uploadFile(String src, String dst,FileSystem hdfs) throws IOException {

		Path srcPath = new Path(src); // 原路径
		Path dstPath = new Path(dst); // 目标路径
		// 调用文件系统的文件复制函数,前面参数是指是否删除原文件，true为删除，默认为false
		hdfs.copyFromLocalFile(false, srcPath, dstPath);

		FileStatus[] fileStatus = hdfs.listStatus(dstPath);
		for (FileStatus file : fileStatus) {
			System.out.println(file.getPath());
		}
		hdfs.close();
	}

	// 创建hdfs目录
	public static void createDir(String dir,FileSystem hdfs) throws IOException {

		Path path = new Path(dir);
		if (hdfs.exists(path)) {
			return;
		}
		hdfs.mkdirs(path);
	}

	// 从HDFS 下载文件 到本地
	@Test
	public static void downloadFile(String hdfsDst, String localSrc,FileSystem hdfs) throws IllegalArgumentException, IOException {

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
    public static void readFile(String uri,FileSystem hdfs) throws IOException{
        
        //判断文件是否存在
        if(!hdfs.exists(new Path(uri))){
            System.out.println("Error ; the file not exists.");
            return;
        }
        InputStream in = null;
        try {
            in = hdfs.open(new Path(uri));
            BufferedReader bf =new BufferedReader(new InputStreamReader(in,"GB2312"));//防止中文乱码
            //复制到标准输出流
            IOUtils.copyBytes(in, System.out, 4096,false);
            /*String line = null;
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeStream(in);
        }
    }
 // 文件重命名
    public static void renameFile(String oldName,String newName,FileSystem hdfs) throws IOException{
        
        Path oldPath = new Path(oldName);
        Path newPath = new Path(newName);
        if (hdfs.exists(oldPath)){
            hdfs.rename(oldPath,newPath);
            System.out.println("重命名成功！");
        }else{
            System.out.println("文件不存在!rename失败!");
        }
    }
	// 判断文件是否存在，存在即删除
	public static void deleteFile(String fileName,FileSystem hdfs) throws IOException {

		Path f = new Path(fileName);
		boolean isExists = hdfs.exists(f);
		if (isExists) { // if exists, delete
			boolean isDel = hdfs.delete(f, true);
			System.out.println(fileName + "  delete? \t" + isDel);
		} else {
			System.out.println(fileName + "  exist? \t" + "notExists");
		}
	}

}
