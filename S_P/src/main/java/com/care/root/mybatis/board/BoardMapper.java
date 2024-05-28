package com.care.root.mybatis.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {
	public int writeSave(BoardDTO dto);
	public ArrayList<BoardDTO> getList(@Param("start") int s, @Param("e") int e);
	public BoardDTO contentView(int writeNo);
	public void upHit(int writeNo);
	public int modify(BoardDTO dto);
	public int delete(int writeNo);
	public void addRep(Map<String, String> map);
	public List<BoardRepDTO> getData(@Param("wg") int wg);
	public int getCounter();
}
