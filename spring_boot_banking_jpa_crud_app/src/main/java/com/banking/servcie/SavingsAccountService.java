package com.banking.servcie;

import java.security.Principal;
import java.util.List;

import com.banking.model.SavingsAccount;

public interface SavingsAccountService {
	
	public SavingsAccount createSavingsAccount();
	public List<SavingsAccount> getAllSavingsAccounts();
	public SavingsAccount findByAccountNumber(long accountNumber);
	public String getSavingsAccountBalance(int savingsAccountId);

}
