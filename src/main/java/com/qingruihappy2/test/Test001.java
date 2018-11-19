package com.qingruihappy2.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qingruihappy2.service.UserService;


public class Test001 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImplb");
		userService.add();
	}

}
