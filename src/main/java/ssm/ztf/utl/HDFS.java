package ssm.ztf.utl;

import java.sql.Timestamp;

import org.apache.hadoop.fs.permission.FsPermission;

public class HDFS {

	private String path;
	private String name;
	private long length;
	private String isDir;
	private short blockReplication;
	private long blockSize;
	private Timestamp modificationTime;
	private FsPermission permission;
	private String owner;
	private String group;

	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	

	public String getIsDir() {
		return isDir;
	}

	public void setIsDir(String isDir) {
		this.isDir = isDir;
	}

	public short getBlockReplication() {
		return blockReplication;
	}

	public void setBlockReplication(short blockReplication) {
		this.blockReplication = blockReplication;
	}

	public long getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}

	public Timestamp getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}

	public FsPermission getPermission() {
		return permission;
	}

	public void setPermission(FsPermission permission) {
		this.permission = permission;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "HDFS [path=" + path + ", name=" + name + ", length=" + length + ", isDir=" + isDir
				+ ", blockReplication=" + blockReplication + ", blockSize=" + blockSize + ", modificationTime="
				+ modificationTime + ", permission=" + permission + ", owner=" + owner + ", group=" + group + "]";
	}	

}
