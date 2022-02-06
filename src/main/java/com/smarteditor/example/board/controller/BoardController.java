package com.smarteditor.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smarteditor.example.board.dto.BoardDTO;
import com.smarteditor.example.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/smartEditor")
	public String openSmartEditor() {
		
		return "smarteditor/newPost";
	}
	
	@PostMapping(value = "/smartEditor/register")
	public String registerBoard(final BoardDTO params) {
		try {
			boolean isRegistered = boardService.registerBoard(params);
			
			if(isRegistered == false) {
				System.out.println("게시글 등록에 실패했습니다.");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println("DB오류");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("시스템오류");
		}
		
		return "redirect:/smartEditor";
	}
	
}
