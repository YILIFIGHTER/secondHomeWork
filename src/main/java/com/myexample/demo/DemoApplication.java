package com.myexample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private BeanFactoryPostProcessor beanFactoryPostProcessor;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
