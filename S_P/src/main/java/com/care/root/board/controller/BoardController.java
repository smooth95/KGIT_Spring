package com.care.root.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	
	@GetMapping("allList")
	public String board(Model model) {
		bs.getList(model);
		
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String writeForm(HttpSession session, HttpServletResponse res) throws IOException {
		return "board/writeForm";
	}
	@PostMapping("writeSave")
	public String writeSave(BoardDTO dto, MultipartFile file, HttpServletRequest req) {
		bs.writeSave(dto, file, req);
		return "redirect:writeForm";
	}
}
