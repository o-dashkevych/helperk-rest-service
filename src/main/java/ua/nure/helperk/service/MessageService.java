package ua.nure.helperk.service;

import ua.nure.helperk.entity.Message;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface MessageService {
	
	void add(Message message);

	void update(Message message);

	void delete(Message message);

	List<Message> getAllMessages();
}
