package com.smarteditor.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smarteditor.example.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/")
	public String openSmartEditor() {
		
		return "smarteditor/newPost";
	}
	
}
