package com.doit.demo.graalvmcloudnativeserver.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DefaultController {

	@GetMapping("/")
	public ResponseEntity<String> sayHello(HttpServletRequest request) throws UnknownHostException {
		String respString;
		respString = "Hello From " + InetAddress.getLocalHost().getHostName() + " Server Processing request From " + request.getRemoteHost() + " / " + request.getRemoteAddr() ;
		return new ResponseEntity<>(respString, HttpStatus.OK);

	}

}
