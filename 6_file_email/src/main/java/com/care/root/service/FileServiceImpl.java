package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl {
	@Autowired
	FileMapper mapper;
	
	public static final String IMG_REPO = "c:/spring";
//	이미지 저장 경로
	
	
	public void fileProcess(MultipartFile file, String id, String name) {
		FileDTO dto = new FileDTO(id, name, "nan");
		// dto를 생성하면서 데이터를 셋팅한다. file이미지의 초기값은 nan으로 설정해둔다.
		
		if (!file.isEmpty()) {
			SimpleDateFormat format = 
					new SimpleDateFormat("yyyyMMddHHmmss-");
			// 시간을 파일앞에 붙이기 위해 시간값 형식을 지정한다.
			
			String sysFileName = format.format(new Date());
			System.out.println("sysfilename : " + sysFileName);
			// 시간을 불러오며 문자열값으로 저장한다.
			//sysFileName => 20240514142815- 의형태로 기록됨
			
			sysFileName += file.getOriginalFilename();
			// 만들어진 시간에 파일의 원본 이름을 추가
			
			dto.setImgName(sysFileName);
			// dto에 만들어진 이미지 이름을 저장한다.
			
			File saveFile = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 미리 지정한 폴더의 경로에 파일 이름을 붙여서 저장한다.
		}
		mapper.saveData( dto );
	}
	
	
	
	public void getData(Model model) {
		model.addAttribute("list", mapper.getData());
	}
	
	public void delete(String file, String id) {
		int result = mapper.delete(id);
		if(result == 1) {
			File d = new File(IMG_REPO+"/"+file);
			d.delete();
		}
	}
	
	public void getDataInfo(Model model, String id) {
		FileDTO dto = mapper.getDataInfo(id);
		model.addAttribute("info", dto);
	}
	
	public void modifyData(String id, String name, String originFile,
			MultipartFile changeFile) {
		FileDTO dto = new FileDTO(id, name, "nan");
		System.out.println(changeFile.getOriginalFilename() == "");
		if (changeFile.getOriginalFilename() != "") {
			dto.setImgName(changeFile.getOriginalFilename());

			SimpleDateFormat format = 
					new SimpleDateFormat("yyyyMMddHHmmss-");
			// 시간을 파일앞에 붙이기 위해 시간값 형식을 지정한다.
			
			String sysFileName = format.format(new Date());
			// 시간을 불러오며 문자열값으로 저장한다.
			//sysFileName => 20240514142815- 의형태로 기록됨
			
			sysFileName += changeFile.getOriginalFilename();
			// 만들어진 시간에 파일의 원본 이름을 추가
			
			dto.setImgName(sysFileName);
			// dto에 만들어진 이미지 이름을 저장한다.
			
			File saveFile = new File(IMG_REPO + "/" + sysFileName);
			try {
				changeFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (originFile != "nan") {
			File d = new File(IMG_REPO+"/"+originFile);
			d.delete();
		}
		int result = mapper.modifyData(dto);
	}
	
	
	
}






















