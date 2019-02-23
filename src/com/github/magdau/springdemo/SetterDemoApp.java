package com.github.magdau.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bean from spring container
		CricketCoach theCoach= context.getBean("myCricketCoach", CricketCoach.class);
		
		//Call method on the bean
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWarkout());
		
		//Call new methods to get the literal value
		System.out.println(theCoach.getEmailAdress());
		
		System.out.println(theCoach.getTeam());
		
		//Close the context
		context.close();
	}
}
