package fr.bank.interview.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.bank.interview.domain.Account;

/**
 * 
 * @author yidoughi
 *
 */

public class AccountDataUtil {

	private static final int maxWithdrawAmount = 450;
	private static final int minWithdrawAmount = 20;

	public static Map<Integer, Account> generateAccounts() {
		Map<Integer, Account> accounts = new HashMap<>();
		double balance = 100;
		for (int i = 1; i <= 15; i++) {
			Account account = new Account(i, new Date(), new Date(), balance, maxWithdrawAmount,
					minWithdrawAmount);
			balance = balance + 100;
			accounts.put(account.getId(), account);
		}
		return accounts;
	}

}
