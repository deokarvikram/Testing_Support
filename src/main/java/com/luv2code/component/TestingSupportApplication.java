package com.luv2code.component;

import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.model.CollegeStudent;
import com.luv2code.component.service.ApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TestingSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSupportApplication.class, args);
	}

	@Bean(name="applicationExample")
	public ApplicationService getApplicationService()
	{
		return new ApplicationService();
	}

	@Bean(name="applicationDao")
	public ApplicationDao getApplicationDao()
	{
		return new ApplicationDao();
	}

	@Bean(name="collegeStudent")
	@Scope(value="prototype")
	CollegeStudent getCollegeStudent()
	{
		return new CollegeStudent();
	}

}
