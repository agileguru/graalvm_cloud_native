package com.doit.demo.graalvmcloudnativeserver.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.UnknownHostException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

class DefaultControllerTest {

	private DefaultController controller;
	
	@Mock
	private HttpServletRequest request;

	@BeforeEach
	void setUp() throws Exception {
		controller = new DefaultController();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testDefaultGetResponseNotNull() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello(request);
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().contains("Hello From ").contains(" Server");
		assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);

	}

	@Test
	void testDefaultGetResponseHasMessage() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello(request);
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().contains("Hello From ").contains(" Server");

	}

	@Test
	void testDefaultGetResponseHasOKStatus() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello(request);
		assertThat(resp).isNotNull();
		assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);

	}

	@Test
	void testDefaultGetResponseHasHostName() throws UnknownHostException {

		ResponseEntity<String> resp = controller.sayHello(request);
		assertThat(resp).isNotNull();
		assertThat(resp.getBody()).isNotNull().hasSizeGreaterThan("Hello From Server".length());

	}

}
