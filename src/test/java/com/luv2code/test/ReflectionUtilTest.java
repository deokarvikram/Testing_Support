package com.luv2code.test;

import com.luv2code.component.TestingSupportApplication;
import com.luv2code.component.model.CollegeStudent;
import com.luv2code.component.model.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestingSupportApplication.class)
public class ReflectionUtilTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach()
    {
        studentOne.setFirstName("Eric");
        studentOne.setLastName("Roby");
        studentOne.setEmailAddress("eric@l2c.com");
        studentOne.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(studentOne,"id",1);
        ReflectionTestUtils.setField(studentOne,"studentGrades", new StudentGrades(
                new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75))
        ));
    }

    @Test
    public void getPrivateFields()
    {
       assertEquals(1, ReflectionTestUtils.getField(studentOne,"id"));
    }

    @Test
    public void invokePrivateMethod()
    {
        assertEquals("Eric 1",ReflectionTestUtils.invokeMethod(studentOne,"getFirstNameAndId"));
    }
}
