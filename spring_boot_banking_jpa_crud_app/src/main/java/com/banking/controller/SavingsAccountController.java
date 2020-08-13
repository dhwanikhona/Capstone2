package com.banking.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.model.SavingsTransfers;
import com.banking.model.User;
import com.banking.model.SavingsAccount;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;
import com.banking.servcie.SavingsTransfersService;

@Controller
public class SavingsAccountController {
	
	@Autowired
	private SavingsTransfersService transfersService;
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
//	@PostMapping("/savingsAccount")
//	public SavingsAccount createSavingsAccount() {
//		return savingsAccountService.createSavingsAccount();
//	}
	
	@GetMapping("/savingsAccount/accountBalance")
	public String getSavingsAccountBalance(@RequestParam("savingsAccountId") int savingsAccountId) {
		System.out.println(savingsAccountId);
		String bal=savingsAccountService.getSavingsAccountBalance(savingsAccountId);
		System.out.println(bal);
		return bal;
	}
	
	@RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransfers> savingsTransactionList = transfersService.findSavingsTransfersList(principal.getName());
        User user = registerService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }

}
