package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.FileDTO;
import com.care.root.service.FileServiceImpl;

@Controller
public class FileController {
	@Autowired FileServiceImpl fs;
	
//	public FileController() {
//		System.out.println("컨트롤러 생성자 실행");
//	}
//	bean 생성 테스트 코드
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping("upload")
	public String upload(@RequestParam String id, 
			@RequestParam String name, MultipartFile file,
			HttpServletRequest req, MultipartHttpServletRequest mReq) {
//		파일 받을때 어노테이션 없이 사용
		System.out.println("id : " + req.getParameter("id"));
		System.out.println("name : " + mReq.getParameter("name"));
		System.out.println("file : " + file.getOriginalFilename());
		MultipartFile file02 = mReq.getFile("file");
		System.out.println("file02 : " + file02.getOriginalFilename());
		
		fs.fileProcess(file, id, name);
		return "redirect:form";
	}
	
	@GetMapping("views")
	public String views(Model model) {
		fs.getData(model);
		return "result";
	}
	
	@GetMapping("download")
	public void download(@RequestParam String file,
							HttpServletResponse res) throws Exception{
		if (!file.equals("nan")) {
		res.addHeader("Content-disposition", "attachment;fileName="+file);
		//응답할때 다운받는 방식이며 파일명을 붙여서 보내준다.
		//contentdisposition값이 달라지면 다운로드가 아니라 페이지에 보여지게된다.
		System.out.println("file : " + file);
			File f = new File(FileServiceImpl.IMG_REPO + "/" + file);
			// 해당 경로에 있는 파일을 가져옴
			System.out.println("1");
			FileInputStream in = new FileInputStream(f);
			System.out.println("2");
			FileCopyUtils.copy(in,  res.getOutputStream());
			System.out.println("3");
			//가져온 파일을 사용자에게 out으로 응답한다.(파일을 보낸다.)
			in.close();
			System.out.println("4");
		}
	}
	@GetMapping("delete")
	public String delete(@RequestParam String file,
			@RequestParam String id) {
		fs.delete(file, id);
		return "redirect:views";
	}
	
	@GetMapping("modify_form")
	public String modifyForm(@RequestParam String id, Model model) {
		fs.getDataInfo(model, id);
		return "modify";
	}
	
	@PostMapping("modify")
	public String modify(@RequestParam String originFile,
			@RequestParam MultipartFile changeFile,
			@RequestParam String id, @RequestParam String name) {
		fs.modifyData(id, name, originFile, changeFile);
		return "redirect:views";
	}
	
}




















