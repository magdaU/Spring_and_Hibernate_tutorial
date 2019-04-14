package com.github.magdau.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.github.magdau.aopdemo.dao.AccountDAO;
import com.github.magdau.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find the accounts
		List<Account>theAccounts= null;
		
		try {
			//add a boolean flag to simulate exceptions
			boolean tripWare = true;
			theAccounts=theAccountDAO.findAccounts(tripWare);
		}
		catch(Exception exc){
			System.out.println("\n\nMain Program ... caught exception: " + exc);					
		}
		
		//display the accounts
		System.out.println("\n\n Main Program : AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
	
		// close the context
		context.close();
	}

}