package com.myexample.demo;

import com.myexample.demo.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	//通过类型来获取Bean
	@Test
	public void getBeanByClass() {
		//(1) 获取Spring容器对象
		//IOC : Inversion Of Control
		ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		//(2) 通过JavaBean的类型来获取bean
		Student bean = ioc.getBean(Student.class);
		//(3) 打印出获取到的bean对象的信息
		System.out.println(bean);
	}

}
