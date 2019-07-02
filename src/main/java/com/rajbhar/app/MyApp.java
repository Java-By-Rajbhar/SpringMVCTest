package com.rajbhar.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rajbhar.model.Student;
import com.rajbhar.model.StudentConfig;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		Student std  = context.getBean("studentBean",Student.class);
		System.out.println("id : "+std.getStd_id()+"------------name : "+std.getStd_name());
		std.message();

	}

}
