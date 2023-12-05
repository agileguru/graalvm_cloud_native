package com.doit.agileguru.graalvmcloudnativeclient.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class DefaultClientControllerTest {

	@Autowired
	private DefaultClientController controller;
	
	@Test
	void testDefaultGetResponseIsNotNull() {
		ResponseEntity<String> resp = controller.getRemoteMessage();
		Assertions.assertThat(resp).isNotNull();
	}
	
	@Test
	void testDefaultGetResponseIsOK() {
		ResponseEntity<String> resp = controller.getRemoteMessage();
		Assertions.assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
	}

	@Test
	void testDefaultGetResponseBodyNotEmpty() {
		ResponseEntity<String> resp = controller.getRemoteMessage();
		Assertions.assertThat(resp.getBody()).isNotNull().isNotEmpty().contains("Hello From ").contains(" Server");
		Assertions.assertThat(resp.getBody()).isNotNull().isNotEmpty().hasSizeGreaterThan("Hello From Server".length());
	}
}
