package com.example.testing;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = { "/posts" })
public class PostsController {
	
	
	 
	@Autowired
	private PostsService postsService;

	
	@GetMapping(path = { "top", "/top" })
	public String getTopPost(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session) throws Exception {
		return postsService.getTopPost();
	}
	
	//Mock data testing 
//	@GetMapping(path = { "/subscription/daily"})
//	public String subscriptionDaily(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session) throws Exception {
//		
//		CommonDTO commonDTO=new CommonDTO(10.00,SubscriptionType.DAILY,"01/09/2021","01/11/2021");
//		return subscriptionService.performSubscription(commonDTO, session, request);
//	}
//	
	
	
}
