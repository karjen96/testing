package com.example.testing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = { "/comments" })
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;

	
	
	@PostMapping(path = { "filter", "/filter" })
	public String subscription(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session,
			@RequestBody final String input) throws Exception {

		System.out.print(input);
		CommentsDTO requestDTO=new Gson().fromJson(input, CommentsDTO.class);
		return commentsService.filterComments(requestDTO, session, request);
	}
	
	
}
