package com.doit.demo.graalvmcloudnativeserver.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.UnknownHostException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class DefaultControllerTest {

	private DefaultController controller;

	@BeforeEach
	void setUp() throws Exception {
		controller = new DefaultController();
	}

	@Test
	void testDefaultGetResponseNotNull() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello();
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().contains("Hello From ").endsWith(" Server");
		assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);

	}

	@Test
	void testDefaultGetResponseHasMessage() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello();
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().contains("Hello From ").endsWith(" Server");

	}

	@Test
	void testDefaultGetResponseHasOKStatus() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello();
		assertThat(resp).isNotNull();
		assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);

	}

	@Test
	void testDefaultGetResponseHasHostName() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello();
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().hasSizeGreaterThan("Hello From Server".length());

	}

}
