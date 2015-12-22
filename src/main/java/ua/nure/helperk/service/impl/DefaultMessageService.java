package ua.nure.helperk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.helperk.dao.MessageDAO;
import ua.nure.helperk.entity.Message;
import ua.nure.helperk.service.MessageService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */

@Service
@Transactional
public class DefaultMessageService implements MessageService {

	@Autowired
	private MessageDAO messageDAO;

	@Override
	public void add(Message message) {
		messageDAO.save(message);
	}

	@Override
	public void update(Message message) {
		messageDAO.save(message);
	}

	@Override
	public void delete(Message message) {
		messageDAO.remove(message);
	}

	@Override
	public List<Message> getAllMessages() {
		return messageDAO.findAll();
	}
}
