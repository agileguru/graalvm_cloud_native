package com.doit.demo.graalvmcloudnativeserver.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultController {

	@GetMapping("/")
	public ResponseEntity<String> sayHello() {
		String respString;
		try {
			respString = "Hello From " + InetAddress.getLocalHost().getHostName() + " Server";
			return new ResponseEntity<String>(respString,HttpStatus.OK);
		} catch (UnknownHostException e) {
			log.warn("Could not determine hostname", e.getLocalizedMessage());
			return new ResponseEntity<String>("Hello From non-deterministic Server",HttpStatus.OK);
		}
		
	}

}
