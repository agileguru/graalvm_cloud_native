package com.doit.agileguru.graalvmcloudnativeclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DefaultClientController {

	@Value("${app.remote.server}")
	private String remoteServer;

	private RestTemplate template = new RestTemplate();

	@GetMapping("/")
	public ResponseEntity<String> getRemoteMessage() {
		ResponseEntity<String> serverResponse = template.getForEntity(remoteServer, String.class);
		return new ResponseEntity<>(serverResponse.getBody(), serverResponse.getStatusCode());
	}

}
