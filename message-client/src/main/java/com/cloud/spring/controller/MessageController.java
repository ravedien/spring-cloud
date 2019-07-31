package com.cloud.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.spring.entity.MessageEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/message")
public class MessageController {

	@HystrixCommand
	@GetMapping("/{id}")
	public MessageEntity getMessage(@PathVariable Integer id) {
		MessageEntity message = new MessageEntity();
		message.setId(id);
		return message;
	}

}
