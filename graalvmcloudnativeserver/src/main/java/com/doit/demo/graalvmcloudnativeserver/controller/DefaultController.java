package com.doit.demo.graalvmcloudnativeserver.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping("/")
	public ResponseEntity<String> sayHello() throws UnknownHostException {
		String respString;
			respString = "Hello From " + InetAddress.getLocalHost().getHostName() + " Server";
			return new ResponseEntity<String>(respString,HttpStatus.OK);
		
	}

}
