package fr.bank.interview.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import fr.bank.interview.domain.Account;
import fr.bank.interview.domain.User;

/**
 * 
 * @author yidoughi
 *
 */

public class Repository {

	private Map<Integer, User> users;
	private Map<Integer, Account> accounts;
	private static Repository db = null;

	private Repository() {
		this.users = UserDataUtil.generateUsers();
		this.accounts = AccountDataUtil.generateAccounts();
	}

	public static Repository getInstance() {
		if (db == null)
			db = new Repository();
		return db;
	}

	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public Map<Integer, User> getUsers() {
		return this.users;
	}

	public User getUser(int userId) {
		return this.users.get(userId);
	}

	public User addUser(User user) {
		this.users.put(user.getId(), user);
		return this.users.get(user.getId());
	}

	public User updateUser(User user) {
		User existedUser = this.users.get(user.getId());
		if (existedUser == null)
			return existedUser;
		return this.users.computeIfPresent(user.getId(), (id, oldUser) -> user);
	}

	public boolean deleteUser(int userId) {
		this.users.remove(userId);
		return this.users.get(userId) == null;
	}

	public Account getAccount(int accountId) {
		return this.accounts.get(accountId);
	}

	public Account addAccount(Account account) {
		if (this.accounts.containsKey(account.getId()))
			return null;

		this.accounts.put(account.getId(), account);
		return this.accounts.get(account.getId());
	}

	public Account updateAccount(Account account) {
		Account existedAccount = this.accounts.get(account.getId());
		if (existedAccount == null)
			return existedAccount;
		return this.accounts.computeIfPresent(account.getId(), (id, oldAccount) -> account);
	}

	public boolean deleteAccount(int userId, int accountId) {
		this.accounts.remove(accountId);
		User user = this.users.get(userId);
		Set<Integer> newAccounts = user.getAccounts();
		newAccounts.remove(accountId);
		user.setAccounts(newAccounts);
		updateUser(user);
		return this.accounts.get(accountId) == null && this.users.get(userId).getAccounts().contains(accountId);
	}

	public List<Account> getAccountsOfUser(int userId) {
		return this.users.get(userId).getAccounts().stream().map(accountId -> getAccount(accountId))
				.collect(Collectors.toList());
	}

	public Account linkAccountToUser(int userId, int accountId) {

		if (this.accounts.containsKey(accountId))
			this.users.get(userId).getAccounts().add(accountId);
		return getAccount(accountId);
	}

	public Account withdrawMoney(int accountId, double money) {

		Account account = getAccount(accountId);
		if (money < account.getMinWithdrawAmount() || money > account.getMaxWithdrawAmount())
			return null;

		account.setBalance(account.getBalance() - money);
		return updateAccount(account);
	}

	public Account depositMoney(int accountId, double money) {
		Account account = getAccount(accountId);
		if (money < 0)
			return account;

		account.setBalance(account.getBalance() + money);
		return updateAccount(account);
	}

	public double getSumAccountsOfUser(int userId) {
		return getAccountsOfUser(userId).stream().mapToDouble(Account::getBalance).sum();
	}

	public Optional<User> getUserByEmail(String email) {
		return this.users.values().stream().filter(u -> u.getEmail().equals(email)).findFirst();

	}
}
