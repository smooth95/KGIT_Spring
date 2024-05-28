package com.care.root.board.service;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public String IMAGE_REPO = "C:/spring/img";
	public String saveFile(MultipartFile mul);
	public void deleteImage( String originName);
}
