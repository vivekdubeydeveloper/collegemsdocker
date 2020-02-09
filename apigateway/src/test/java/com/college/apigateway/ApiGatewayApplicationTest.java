package com.college.apigateway;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiGatewayApplicationTest {

	private static final String BASE_URL = "/subjects";
	
	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	
	int randomServerPort=8080;

	RestTemplate restTemplate;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Ignore
	@Test
	public void testGetSubjects() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL;
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> employeesEntity = restTemplate.getForEntity(url, List.class);
		Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

}
