package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Message;
import emlakcepte.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	@Autowired
	private MessageService service;
	
	@GetMapping
	public List<Message> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public Message create(@RequestBody Message message) {
		service.createMessage(message);
		return message;
	}
}
