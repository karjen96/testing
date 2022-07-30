package com.example.testing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class CommentsService extends CommonService{

	public String filterComments(final CommentsDTO commentDTO , final HttpSession session, final HttpServletRequest request)  {

		List<CommentsDTO> commentsDTO =  g.fromJson(getMethod(COMMENTS_URL), listCommentsDTO);
        	
		Stream<CommentsDTO> commentStream = commentsDTO.stream();
		
		if (commentDTO.getPostId() != null&&commentDTO.getPostId() >0) {
			commentStream = commentStream.filter(c -> c.getPostId()==commentDTO.getPostId());
		}
		if(commentDTO.getId()!=null&&commentDTO.getId() >0) {
			commentStream = commentStream.filter(c -> c.getId()==commentDTO.getId());
		}
		if(StringUtils.hasText(commentDTO.getName())) {
			commentStream = commentStream.filter(c ->c.getName().matches("(?i).*"+commentDTO.getName()+".*"));
		}
		if(StringUtils.hasText(commentDTO.getEmail())) {
			commentStream = commentStream.filter(c ->c.getEmail().matches("(?i).*"+commentDTO.getEmail()+".*"));
		}
		if(StringUtils.hasText(commentDTO.getBody())) {
			commentStream = commentStream.filter(c ->c.getBody().matches("(?i).*"+commentDTO.getBody()+".*"));
		}
		commentsDTO = commentStream.collect(Collectors.toList());
		return g.toJson(commentsDTO);
	}




}
