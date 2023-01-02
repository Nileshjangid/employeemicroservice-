package com.restapi.employeemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class EmployeemicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void getgreetingsTest() throws URISyntaxException {
		System.out.println("Test started");
		RestTemplate template = new RestTemplate();
		String url ="http://localhost:8080/getmsg/nilesh";
		URI uri = new URI(url);
		ResponseEntity<String> response = template.getForEntity(uri, String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());

		System.out.println("Test end ");
	}
}











