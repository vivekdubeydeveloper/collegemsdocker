package com.college.student;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.college.student.entity.Student;
import com.college.student.exception.StudentNotFound;
import com.college.student.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentProducerApplicationTest {

	private static final String BASE_URL = "/students";
	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	@LocalServerPort
	int randomServerPort;

	RestTemplate restTemplate;
	
	@Autowired
	StudentService studentServiceImpl;
	
	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetStudents() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL;
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> employeesEntity = restTemplate.getForEntity(url, List.class);
		Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

	@Test
	public void testGetStudent() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix +BASE_URL+ "/1";
		ResponseEntity<Student> employeesEntity = restTemplate.getForEntity(url, Student.class);
		String expected = "Rajesh";
		Assert.assertEquals(expected, employeesEntity.getBody().getName());
	}
	
	@Test(expected = StudentNotFound.class)
	public void testGetStudentNotFound() {
		studentServiceImpl.getStudent(999);
	}
	
}
