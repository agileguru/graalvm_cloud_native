package com.doit.demo.graalvmcloudnativeserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping("/")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello From Server",HttpStatus.OK);
	}

}
