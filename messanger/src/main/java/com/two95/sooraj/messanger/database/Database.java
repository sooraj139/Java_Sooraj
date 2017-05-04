package com.two95.sooraj.messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.two95.sooraj.messanger.model.Comment;
import com.two95.sooraj.messanger.model.Message;
import com.two95.sooraj.messanger.model.Profile;

public class Database {
	
	private static Map<Long, Message> messages=new HashMap<>();

	private static Map<Long, Comment> comments=new HashMap<>();
	private static Map<String, Profile> profiles=new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	public static Map<String, Profile> getAllProfiles(){
		return profiles;
	}
	public static Map<Long, Comment> getAllComments(){
		return comments;
	}

}
