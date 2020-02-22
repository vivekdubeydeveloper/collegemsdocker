package com.college.teacher;

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

import com.college.teacher.entity.Teacher;
import com.college.teacher.exception.TeacherNotFound;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TeacherApplicationTest {

	private static final String BASE_URL = "/teachers";
	
	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	@LocalServerPort
	int randomServerPort;

	RestTemplate restTemplate;
	
	@Autowired
	TeacherService teacherService;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetTeachers() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + BASE_URL;
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> employeesEntity = restTemplate.getForEntity(url, List.class);
		Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

	@Test
	public void testGetTeacher() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + BASE_URL + "/1";
		ResponseEntity<Teacher> employeesEntity = restTemplate.getForEntity(url, Teacher.class);
		String expected = "Rajesh";
		Assert.assertEquals(expected, employeesEntity.getBody().getName());
	}

	
	@Test(expected = TeacherNotFound.class)
	public void testTeacherNotFound() {
		teacherService.getTeacher(9999);
	}
	 

	@Test
	public void testAddTeacher() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + BASE_URL;
		Teacher teacher = new Teacher();
		teacher.setName("Shanker");
		teacher.setAddress("Dubai");
		teacher.setSubjectId(1);
		ResponseEntity<ResponseBean> employeesEntity = restTemplate.postForEntity(url, teacher, ResponseBean.class);
		Assert.assertTrue(employeesEntity.getStatusCode() == HttpStatus.CREATED);
	}

	@Test
	public void testUpdateTeacher() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + BASE_URL;
		Teacher teacher = new Teacher();
		teacher.setEmpid(3);
		teacher.setName("Mukund");
		teacher.setAddress("Australia");
		teacher.setSubjectId(2);

		HttpHeaders requestHeaders = getHttpHeaders();
		HttpEntity<Teacher> requestEntity = new HttpEntity<>(teacher, requestHeaders);

		ResponseEntity<ResponseBean> employeesEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
				ResponseBean.class);

		Assert.assertTrue(employeesEntity.getBody().getMsg().contains(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY));
	}

	@Ignore
	@Test
	public void testDeleteTeacherById() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + BASE_URL + "/5";

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
