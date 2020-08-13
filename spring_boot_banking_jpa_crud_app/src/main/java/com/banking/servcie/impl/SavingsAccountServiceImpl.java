package com.banking.servcie.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.SavingsAccountDAO;
import com.banking.model.SavingsAccount;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;


@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private SavingsAccountDAO dao;
	
	private static long count = 10000000;

	@Override
	public SavingsAccount createSavingsAccount() {
		
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountNumber(accountGenerator());
		savingsAccount.setAccountBalance(new BigDecimal(0.0));
		dao.save(savingsAccount);
		
		return dao.findByAccountNumber(savingsAccount.getAccountNumber());
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		
		return dao.findAll();
	}
	
	
	private long accountGenerator() {
		return ++count;
	}

	@Override
	public SavingsAccount findByAccountNumber(long accountNumber) {
		
		return dao.findByAccountNumber(accountNumber);
	}

	@Override
	public String getSavingsAccountBalance(int savingsAccountId) {
//		User user = registerService.user.getSavingsAccountByAccountNumber()
		System.out.println("inside impl");
		SavingsAccount account= dao.findById(savingsAccountId).get();
		System.out.println(account.toString());
		BigDecimal bal=account.getAccountBalance();
		System.out.println(bal);
		System.out.println(bal.toString());
		return bal.toString();
		
	}
	

}
