package com.github.magdau.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.magdau.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
		
	//After will run for success or faillure(finally)
	@After("execution(* com.github.magdau.aopdemo.dao.AccountDAO.findAccounts(..))")
		public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint) {
		
		//print out which method we are advising on
		String method= theJointPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @After (finally) on method " + method);
				
		}
	
	@AfterThrowing(
		pointcut="execution(* com.github.magdau.aopdemo.dao.AccountDAO.findAccounts(..))",   
		throwing="theExc")	
		public void afterThrowingFindAccountsAdvice(
				JoinPoint theJointPoint, Throwable theExc) {
	
		//print out which method we are advising on
		String method= theJointPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterThrowing on method: " + method);
		
		//log the exception
		System.out.println("\n ====> The exeption is: " + theExc);		
		}	
	
	@AfterReturning(
		pointcut="execution(* com.github.magdau.aopdemo.dao.AccountDAO.findAccounts(..))",    
		returning ="result")
		public void afterReturningFindAccountsAdvice(
			JoinPoint theJointPoint, List<Account> result) {
		
		//print out which method we are advising on
		String method= theJointPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterReturning on method: " + method);
		
		//print out the results of the method call
		System.out.println("\n ====> result is: " + result);
		
		//let's post-process the data ...let;s modify it :-)
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n ====> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		//loop through accounts
		for(Account tempAccount : result) {	
			
			//get uppercase version of name
			String theUpperName= tempAccount.getName().toUpperCase();
		
			//update the name on the account
			tempAccount.setName(theUpperName);
		}		
	}

	@Before("com.github.magdau.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint) {		
		System.out.println("\n=====>>> Executing @Before advice on method");	
		
		//display the method signature
		MethodSignature methoSig = (MethodSignature) theJointPoint.getSignature();
		System.out.println("Method:" + methoSig);
		
		//display method arguments
		
		
		//get args
		Object [] args= theJointPoint.getArgs();
		
		//loop thru args
		for( Object tempArgs : args) {
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Account) {
				
				//downcast and print Account specific stuff
				Account theAccount = (Account)tempArgs;
				
				System.out.println("account name" + theAccount.getName());
				System.out.println("account name" + theAccount.getLevel());
			}
		}
			
	}
	
}