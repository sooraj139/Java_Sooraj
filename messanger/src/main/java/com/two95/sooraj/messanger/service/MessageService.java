package com.two95.sooraj.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.exceptions.i18n.DatabaseExceptionResource;

import com.two95.sooraj.messanger.database.Database;
import com.two95.sooraj.messanger.exception.DataNotFoundException;
import com.two95.sooraj.messanger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = Database.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello", "Sooraj" ));
		messages.put(2L, new Message(2, "How is everybody?", "Sooraj"));
		

	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(long id) {
		Message message= messages.get(id);
		if(message==null){
			throw new DataNotFoundException("Message with id "+id+" not found ");
		}
		return message;

	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;

	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	public List<Message> getAllMessagesPerYear(int year){
		List<Message> perYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				perYear.add(message);
			}
		}
		return perYear;		
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> list=new ArrayList<>(messages.values());
		if(start+size>messages.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
	}

}
