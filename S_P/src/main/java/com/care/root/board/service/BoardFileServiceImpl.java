package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardFileServiceImpl implements BoardFileService{
	public String saveFile(MultipartFile mul) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
		
		String sysFileName = format.format(new Date());
		sysFileName += mul.getOriginalFilename();
		
		File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
		try {
			mul.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
		
	}

	public void deleteImage(String originName) {
		File file = new File(IMAGE_REPO + "/" + originName);
		if(file.exists())
			file.delete();
	}
}
