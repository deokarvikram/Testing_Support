package com.luv2code.test;

import com.luv2code.component.TestingSupportApplication;
import com.luv2code.component.model.CollegeStudent;
import com.luv2code.component.model.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestingSupportApplication.class)
class ApplicationExampleTest {

	private static int count=0;

	@Value("${info.app.name}")
	private String appInfo;

	@Value("${info.app.description}")
	private String description;

	@Value("${info.app.version}")
	private String version;

	@Value("${info.school.name}")
	private String schoolName;

	@Autowired
	CollegeStudent student;

	@Autowired
	StudentGrades studentGrades;

	@Autowired
	ApplicationContext context;

	@BeforeEach
	public void beforeEach()
	{
			count=count+1;
			System.out.println("Testing:"+appInfo+" which is "+description+" version:"+version+". Execution of test method"+count);
			student.setFirstName("Eric");
			student.setLastName("Roby");
			student.setEmailAddress("eric.roby@luv2code_school.com");
			studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0,85.0,76.50,91.75)));
			student.setStudentGrades(studentGrades);

	}

	@DisplayName("Add grade results for student grades not equal")
	@Test
	public void addGradeResultsForStudentGradesAssertNotEquals()
	{
				assertNotEquals(0,studentGrades.addGradeResultsForSingleClass(
						student.getStudentGrades().getMathGradeResults()
				));
	}

	@DisplayName("Is grade greater")
	public void isGradeGreaterStudentGrade()
	{
		assertTrue(studentGrades.isGradeGreater(90,75),"failure - should be true");
	}
	@DisplayName("Check Null for student grades")
	@Test
	public void checkNullForStudentGrades() {
		assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()),
				"object should not be null");
	}

	@DisplayName("Create student without grade init")
	@Test
	public void createStudentWithoutGradesInit() {
		CollegeStudent studentTwo=context.getBean("collegeStudent",CollegeStudent.class);
		studentTwo.setFirstName("Chad");
		studentTwo.setLastName("Darby");
		studentTwo.setEmailAddress("chad.darby@luv2code_school.com");
		assertNotNull(studentTwo.getFirstName());
		assertNotNull(studentTwo.getLastName());
		assertNotNull(studentTwo.getEmailAddress());
		assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
	}

	@DisplayName("Verify students are prototypes")
	@Test
	public void verifyStudentsArePrototype()
	{
		CollegeStudent studentTwo=context.getBean("collegeStudent",CollegeStudent.class);
		assertNotSame(student,studentTwo);
	}

	@DisplayName("Find Grade point average")
	@Test
	public void findGradePointAverage()
	{
		assertAll(
				"Testing all assert equals",
				()-> assertEquals(353.25,studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults())),
				()-> assertEquals(88.31,studentGrades.findGradePointAverage(student.getStudentGrades().getMathGradeResults()))
		);
	}


	@Test
	void contextLoads() {
	}

}
