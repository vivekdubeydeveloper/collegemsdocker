package com.college.student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.college.student.controller.StudentController;
import com.college.student.entity.Student;
import com.college.student.model.ResponseBean;
import com.college.student.service.StudentService;
import com.college.student.util.MessageConstant;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentProducerApplicationMockitoTest {

	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	@LocalServerPort
	int randomServerPort;

	
	@Mock
	private StudentService studentService;
	
	@InjectMocks
	private StudentController studentController;
	
	@Value("${topic.create.student}")
	private String createStudentTopic;
	
	@Value("${topic.update.student}")
	private String updateStudentTopic;
	
	
	@Value("${topic.delete.student.id}")
	private String deleteStudentTopic;

	@Before
	public void init() {
		 MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setName("Shanker");
		student.setAddress("Dubai");
		
		ResponseBean rb=new ResponseBean();
		String msg = MessageConstant.DATA_PUSHED_IN_KAFKA;
		rb.setMsg(msg);
		
		Mockito.when(studentService.addUpdateStudent(student, createStudentTopic)).thenReturn(rb);
		ResponseBean result=studentController.addStudent(student);
		Assert.assertTrue(result.getMsg().contains(MessageConstant.DATA_PUSHED_IN_KAFKA));
	}
	
	
	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setRollno(1);
		student.setName("Mukund");
		student.setAddress("Australia");
		
		ResponseBean rb=new ResponseBean();
		String msg = MessageConstant.DATA_PUSHED_IN_KAFKA;
		rb.setMsg(msg);
		
		Mockito.when(studentService.addUpdateStudent(student, updateStudentTopic)).thenReturn(rb);
		ResponseBean result=studentController.updateStudent(student);
		Assert.assertTrue(result.getMsg().contains(MessageConstant.DATA_PUSHED_IN_KAFKA));
	}
}
