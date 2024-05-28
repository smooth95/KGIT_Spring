package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	
	@GetMapping("allList")
	public String board(Model model, HttpServletRequest req, @RequestParam(value="start", required = false, defaultValue = "1") int start) {
		bs.getList(model, req, start);
		
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String writeForm(HttpSession session, HttpServletResponse res) throws IOException {
		return "board/writeForm";
	}
	@PostMapping("writeSave")
	public void writeSave(BoardDTO dto, MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException {
		String msg = bs.writeSave(dto, file, req, res);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@GetMapping("contentView")
	public String contentView(@RequestParam int writeNo, Model model) {
		bs.contentView(writeNo, model);
		return "board/contentView";
	}
	@GetMapping("download")
	public void download(@RequestParam String fileName, HttpServletResponse res) throws Exception {
		res.addHeader("Content-disposition", "attachment;fileName="+fileName);
		File file = new File(BoardFileService.IMAGE_REPO + "/" + fileName);
		if(file.exists()) {
			FileInputStream in = new FileInputStream(file);
			FileCopyUtils.copy(in, res.getOutputStream());
			in.close();			
		}
	}
	@GetMapping("modify_form")
	public String modifyForm(Model model, @RequestParam int writeNo) {
		bs.contentView(writeNo, model);
		return "board/modify_form";
	}
	@PostMapping("modify")
	public void modify(MultipartHttpServletRequest mul, HttpServletResponse res, HttpServletRequest req) throws Exception {
		String msg = bs.modify(mul);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@GetMapping("delete")
	public void delete(@RequestParam int writeNo, @RequestParam String fileName, HttpServletResponse res) throws IOException {
		String msg = bs.delete(writeNo, fileName);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
		
		
	}
}
