package com.example.testing;

public class TopPostDTO {

	private Integer post_id;
	private String post_title;
	private String post_body;
	private Integer total_number_of_comments;
	
	public TopPostDTO() {}
	
	public TopPostDTO(Integer integer, String post_title, String post_body,Integer total_number_of_comments) {

		this.post_id = integer;
		this.post_title = post_title;
		this.post_body = post_body;
		this.total_number_of_comments=total_number_of_comments;
	}
	
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_body() {
		return post_body;
	}
	public void setPost_body(String post_body) {
		this.post_body = post_body;
	}
	public Integer getTotal_number_of_comments() {
		return total_number_of_comments;
	}
	public void setTotal_number_of_comments(Integer total_number_of_comments) {
		this.total_number_of_comments = total_number_of_comments;
	}
	
}
