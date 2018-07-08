package fr.bank.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.SortOrder;

import fr.bank.interview.domain.Account;

/**
 * 
 * @author yidoughi
 *
 */

public class AccountService extends Service implements IAccountService {

	public AccountService() {
	}

	public Account addAccount(Account account) {
		return this.internalDB.addAccount(account);
	}

	public Account updateAccount(int accountId, Account account) {
		return this.internalDB.updateAccount(account);
	}

	public boolean deleteAccount(int userId, int accountId) {
		return this.internalDB.deleteAccount(userId, accountId);
	}

	public Account linkAccountToUser(int userId, int accountId) {
		return this.internalDB.linkAccountToUser(userId, accountId);
	}

	public List<Account> getAccounts(SortOrder sort) {
		return this.internalDB.getAccounts().values().stream().collect(Collectors.toList());
	}

	public List<Account> getAccountsOfUser(int userId) {
		return this.internalDB.getAccountsOfUser(userId);
	}

	public Account updateAccount(Account account) {
		return this.internalDB.updateAccount(account);
	}

	public Optional<Account> findAccountById(int id) {
		if (this.internalDB.getAccount(id) == null)
			return Optional.empty();
		return Optional.ofNullable(this.internalDB.getAccount(id));
	}

	public Account depositMoney(int accountId, double amount) {
		return this.internalDB.depositMoney(accountId, amount);
	}

	public Account whidhdrawMonney(int accountId, double amount) {
		return this.internalDB.withdrawMoney(accountId, amount);
	}

	public double getSumAccountsOfUser(int userId) {
		return this.internalDB.getSumAccountsOfUser(userId);
	}

}
