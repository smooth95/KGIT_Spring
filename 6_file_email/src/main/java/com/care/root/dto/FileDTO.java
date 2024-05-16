package com.care.root.dto;

public class FileDTO {
	String id, name, imgName;
	
	public FileDTO() {
		
	}
	
	public FileDTO(String id, String name, String imgName) {
		this.id = id;
		this.name = name;
		this.imgName = imgName;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String img_name) {
		this.imgName = img_name;
	}
}
