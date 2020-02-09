package com.college.subject;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.college.subject.entity.Subject;
import com.college.subject.exception.SubjectNotFound;
import com.college.subject.model.ResponseBean;
import com.college.subject.service.SubjectService;
import com.college.subject.util.MessageConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SubjectApplicationTest {

	private static final String BASE_URL = "/subjects";
	
	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	@LocalServerPort
	int randomServerPort;

	RestTemplate restTemplate;
	
	@Autowired
	SubjectService subjectService;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetSubjects() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL;
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> employeesEntity = restTemplate.getForEntity(url, List.class);
		Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

	@Ignore
	@Test
	public void testGetSubject() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL+ "/1";
		ResponseEntity<Subject> employeesEntity = restTemplate.getForEntity(url, Subject.class);
		String expected = "Math";
		Assert.assertEquals(expected, employeesEntity.getBody().getName());
	}

	@Test(expected = SubjectNotFound.class)
	public void testSubjectNotFound() {
		subjectService.getSubject(999999);
	}

	@Test
	public void testAddSubject() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL;
		Subject subject = new Subject();
		subject.setName("MFCS");
		ResponseEntity<ResponseBean> employeesEntity = restTemplate.postForEntity(url, subject, ResponseBean.class);
		Assert.assertTrue(employeesEntity.getStatusCode() == HttpStatus.CREATED);
	}

	@Test
	public void testUpdateSubject() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL;
		Subject subject = new Subject();
		subject.setId(6);
		subject.setName("CBNST");

		HttpHeaders requestHeaders = getHttpHeaders();
		HttpEntity<Subject> requestEntity = new HttpEntity<>(subject, requestHeaders);

		ResponseEntity<ResponseBean> employeesEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
				ResponseBean.class);

		Assert.assertTrue(employeesEntity.getBody().getMsg().contains(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY));
	}

	@Ignore
	@Test
	public void testDeleteSubjectById() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL+"/7";

		HttpHeaders requestHeaders = getHttpHeaders();
		HttpEntity<Integer> requestEntity = new HttpEntity<>(requestHeaders);

		ResponseEntity<ResponseBean> employeesEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
				ResponseBean.class);
		Assert.assertTrue(employeesEntity.getBody().getMsg().contains(MessageConstant.OBJECT_DELETED_SUCCESSFULLY));
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		return requestHeaders;
	}

}
