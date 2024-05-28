package com.care.root.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Autowired ServletContext sc;
	@Autowired BoardFileService bfs;
			
	@Override
	public String writeSave(BoardDTO dto, MultipartFile file, HttpServletRequest req, HttpServletResponse res) {
		dto.setImageFileName("nan");
		
		System.out.println("file : " + file.getOriginalFilename());
		System.out.println(file.getOriginalFilename() == "");
		System.out.println("req : " + req.getContextPath());
		if (file.getOriginalFilename() != "") { // file.isEmpty()사용가능
			dto.setImageFileName(bfs.saveFile(file));
		}
		int result = mapper.writeSave(dto);
		String msg, url;
		if (result == 1) {
			msg = "새 글이 추가되었다.!!!";
			url = "/board/allList";
		} else {
			msg = "문제 발생!!!";
			url = "/board/writeForm";
		}
		return getMessage(msg, url);
		
	}
	
	public String getMessage(String msg, String url) {
		String message = "<script> alert('"+msg+"');";
		message += "location.href='/root/"+url+"';</script>";
		return message;
	}
	
	@Override
	public void getList(Model model, HttpServletRequest req, int start) {
		int pageLetter = 3;
		int allCount = mapper.getCounter();
		int repeat = allCount / pageLetter;
		if (allCount % pageLetter != 0) {
			repeat += 1;
		}
		int e = start * pageLetter;
		int s = e + 1 - pageLetter;
		model.addAttribute("repeat", repeat);
		model.addAttribute("list", mapper.getList(s, e));
		
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
	@Override
	public void contentView(int writeNo, Model model) {
		upHit(writeNo);
		model.addAttribute("dto", mapper.contentView(writeNo));
	}

	public String modify(MultipartHttpServletRequest mul) {
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo( Integer.parseInt(mul.getParameter("writeNo")));
		dto.setTitle( mul.getParameter("title"));
		dto.setContent( mul.getParameter("content"));
		
		MultipartFile m = mul.getFile("imageFileName");
		if(m.isEmpty()) {
			dto.setImageFileName(mul.getParameter("originName"));
		} else {
			dto.setImageFileName(bfs.saveFile(m));
			bfs.deleteImage( mul.getParameter("originName"));
		}
		int result = mapper.modify( dto );
		String msg, url;
		if (result == 1) {
			msg = "수정 성공!!!";
			url = //mul.getContextPath() + 
					"/board/allList?writeNo="+dto.getWriteNo();
		} else {
			msg = "문제 발생!!!";
			url = //mul.getContextPath() + 
					"/board/modify_form?writeNo="+dto.getWriteNo();
			
		}
		return getMessage(msg, url);
	}

	public String delete(int writeNo, String fileName) {
		int result = mapper.delete( writeNo );
		String msg, url;
		if (result == 1) {
			msg = "삭제 성공!!!";
			url = "/board/allList";
			bfs.deleteImage(fileName);
		} else {
			msg = "문제 발생!!!";
			url = "/board/contentView?writeNo="+writeNo;
		}
		return getMessage(msg, url);
	}

	@Override
	public void addRep(Map<String, String> map, String userId) {
		map.put("userId", userId);
		mapper.addRep( map );
	}

	@Override
	public List<BoardRepDTO> getData(int wg) {
		
		return mapper.getData( wg );
	}
	
	
	
}
