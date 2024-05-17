package com.care.root.board.service;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Autowired ServletContext sc;
	
			
	@Override
	public void writeSave(BoardDTO dto, MultipartFile file, HttpServletRequest req) {
		dto.setImageFileName("nan");
		
		System.out.println("file : " + file.getOriginalFilename());
		System.out.println(file.getOriginalFilename() == "");
		if (file.getOriginalFilename() != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			
			String sysFileName = format.format(new Date());
			System.out.println("sysfilename : " + sysFileName);
			sysFileName += file.getOriginalFilename();
			System.out.println("test1");
			dto.setImageFileName(sysFileName);
			System.out.println("test2");
			System.out.println("path : " + req.getServletContext().getRealPath("resources/image/"));
			File saveFile = new File(req.getServletContext().getRealPath("src/image/") + sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		mapper.writeSave(dto);
	}
	@Override
	public void getList(Model model) {
		ArrayList<BoardDTO> list =  mapper.getList();
		model.addAttribute("list", list);
		
	}
	
}
