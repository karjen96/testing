package com.example.testing;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CommonService {

	protected Gson g = new Gson();
	protected Type listCommentsDTO = new TypeToken<ArrayList<CommentsDTO>>(){}.getType();
	protected Type listPostsDTO = new TypeToken<ArrayList<PostsDTO>>(){}.getType();
	protected final String POSTS_URL="https://jsonplaceholder.typicode.com/posts";
	protected final String COMMENTS_URL="https://jsonplaceholder.typicode.com/comments";
	
	 @Autowired
	 RestTemplate restTemplate;
	 
	protected String getMethod(String url) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    
	    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
}
