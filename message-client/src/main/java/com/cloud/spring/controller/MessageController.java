package com.cloud.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@ResponseBody
public class MessageController {

	@HystrixCommand
	@GetMapping("/{id}")
	public String getMessage(@PathVariable String id) {
		return "customer: " + id;
	}

}
