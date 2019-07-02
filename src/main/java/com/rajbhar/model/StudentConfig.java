package com.rajbhar.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	public Student studentBean()
	{
		return new Student();
	}
	
	public StudentConfig()
	{
		System.out.println("student config loaded");
	}
}
