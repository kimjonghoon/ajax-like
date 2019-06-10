package net.java_school.board;

public class AttachFile {

	private static int FILE_NO = 1;
	private int fileNo;
	private String filename;
	private boolean deletable;

	public AttachFile() {
		fileNo = FILE_NO++;
		deletable = true;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public boolean isDeletable() {
		return deletable;
	}
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

}