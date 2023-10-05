package com.travel.bean;

import org.springframework.web.multipart.MultipartFile;

public class ImageForm {

	private String folderName;
	private MultipartFile file;
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
