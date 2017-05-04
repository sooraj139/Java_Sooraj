package com.two95.sooraj.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.two95.sooraj.messanger.database.Database;
import com.two95.sooraj.messanger.model.Comment;
import com.two95.sooraj.messanger.model.Message;

public class CommentService {
	private Map<Long, Message>messages=Database.getMessages();
	
	
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment>comments=messages.get(messageId).getComments();
		System.out.println(comments.values());
		return new ArrayList<Comment>(comments.values());	
	}
	public Comment getComment(long messageId, long commentId){
		Map<Long,Comment>comments=messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	public Comment addComment(long messageId, Comment comment){
		Map<Long,Comment>comments=messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;	
	}
	public Comment removeComment(long messageId, long commentId){
		Map<Long,Comment>comments=messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	public Comment updateComment(long messageId, Comment comment){
		if(comment.getId()<0) return null;
		Map<Long,Comment>comments=messages.get(messageId).getComments();
		return comments.put(comment.getId(),comment );
	}

}
