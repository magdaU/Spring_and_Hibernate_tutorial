package com.github.magdau.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.github.magdau.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
