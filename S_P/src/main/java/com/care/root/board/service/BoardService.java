package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;

public interface BoardService {
	public void writeSave(BoardDTO dto, MultipartFile file, HttpServletRequest req);
	public void getList(Model model);
}
