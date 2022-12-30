package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.model.Message;
import emlakcepte.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void createMessage(Message message) {
		messageRepository.createMessage(message);
	}
	
	public List<Message> getAll() {
		return messageRepository.findAll();
	}
	
	
}
