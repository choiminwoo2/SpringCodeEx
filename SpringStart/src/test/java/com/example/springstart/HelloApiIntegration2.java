package com.example.springstart;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = {SpringStartApplication.class})
public class HelloApiIntegration2 {

		@LocalServerPort
		private int port;
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		@Test
		void helloApi(){
				final String BASE_URL = "http://localhost:" + port + "/hello?name={name}";
				System.out.println(BASE_URL);
				ResponseEntity<String> res = testRestTemplate.getForEntity(BASE_URL, String.class, "Spring");

				assertEquals(res.getStatusCode(), HttpStatus.OK);
				assertEquals(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE).startsWith(MediaType.TEXT_PLAIN_VALUE), true);
				assertEquals(res.getBody(), "HelloSpring");

		}

}
