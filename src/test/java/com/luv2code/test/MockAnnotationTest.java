package com.luv2code.test;

import com.luv2code.component.TestingSupportApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.model.CollegeStudent;
import com.luv2code.component.model.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TestingSupportApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @Mock
    ApplicationDao applicationDao;

    @InjectMocks
    ApplicationService applicationService;

    @BeforeEach
    public void beforeEach()
    {
        studentOne.setFirstName("Eric");
        studentOne.setLastName("Roby");
        studentOne.setEmailAddress("eric.roby@luv2code.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("when and verify")
    @Test
    public void assertEqualsTestGrades()
    {
        when(applicationDao.addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100.00, applicationService.addGradeResultsForSingleClass(
                studentOne.getStudentGrades().getMathGradeResults()
        ));

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults());
    }




}
