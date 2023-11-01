package com.doit.demo.graalvmcloudnativeserver.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class DefaultControllerTest {

	private DefaultController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		controller = new DefaultController();
	}

	@Test
	void testDefaultGetResponseNotNull() {

	 ResponseEntity<String> resp = controller.sayHello();
	 assertThat(resp).isNotNull();
	 assertThat(resp.getBody()).isNotNull().isEqualTo("Hello From Server");
	 assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
	 
	}
	
	@Test
	void testDefaultGetResponseHasMessage() {

	 ResponseEntity<String> resp = controller.sayHello();
	 assertThat(resp).isNotNull();
	 assertThat(resp.getBody()).isNotNull().isEqualTo("Hello From Server");
	 
	}
	
	
	@Test
	void testDefaultGetResponseHasOKStatus() {

	 ResponseEntity<String> resp = controller.sayHello();
	 assertThat(resp).isNotNull();
	 assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
	 
	}

}
