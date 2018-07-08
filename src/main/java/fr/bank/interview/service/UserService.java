package fr.bank.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.SortOrder;

import fr.bank.interview.domain.Account;
import fr.bank.interview.domain.User;
import fr.bank.interview.util.Repository;

public class UserService extends Service implements IUserService {
	
	public UserService() {
	}

	public Repository getInternalDB() {
		return internalDB;
	}

	public User addUser(User user) {
		return this.internalDB.addUser(user);
	}

	public User updateUser(User user) {
		return this.internalDB.updateUser(user);
	}

	public boolean deleteUser(int id) {
		return this.internalDB.deleteUser(id);
	}

	public Optional<User> getUserById(String id) {
		return Optional.of(this.internalDB.getUsers().get(id));
	}

	public List<User> getUsers(SortOrder sort) {
		return this.internalDB.getUsers().values().stream().collect(Collectors.toList());
	}

	public List<Account> getUserAccounts(int userId) {
		return this.internalDB.getAccountsOfUser(userId);
	}

	public Optional<User> getUserByEmail(String email) {
		return this.internalDB.getUserByEmail(email);
	}
}
