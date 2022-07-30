package com.example.testing;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class PostsService extends CommonService {


	public String getTopPost()  {

		//get all from url data
		List<CommentsDTO> commentsDTO =  g.fromJson(getMethod(COMMENTS_URL), listCommentsDTO);
		List<PostsDTO> postsDTO =  g.fromJson(getMethod(POSTS_URL), listPostsDTO);
		
		//get the totalComments
		Map<Integer, Long> totalComments= commentsDTO.stream().collect(Collectors.groupingBy(CommentsDTO::getPostId, Collectors.counting()));

		return constructResponseDTO(postsDTO,totalComments);
	}

	private String constructResponseDTO(List<PostsDTO> postsDTO,Map<Integer, Long> totalComments) {
		return g.toJson(constructTopPostDTO(postsDTO,totalComments));
	}
	
	private TopPostDTO constructTopPostDTO(List<PostsDTO> postsDTO,Map<Integer, Long> totalComments){
		List<TopPostDTO> postDTOComments=postsDTO.stream()
		        .map(dto -> new TopPostDTO(dto.getId(), dto.getTitle(), dto.getBody(), totalComments.get(dto.getId()).intValue()))
		        .collect(Collectors.toList());

		return postDTOComments.stream()
			      .max(Comparator.comparing(TopPostDTO::getTotal_number_of_comments))
			      .orElseThrow(NoSuchElementException::new);
	}

}
