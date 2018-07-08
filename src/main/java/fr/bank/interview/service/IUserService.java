package fr.bank.interview.service;

import java.util.List;
import java.util.Optional;

import javax.swing.SortOrder;

import fr.bank.interview.domain.Account;
import fr.bank.interview.domain.User;
/**
 * 
 * @author yidoughi
 *
 */

public interface IUserService {

	User addUser(User user);

	User updateUser(User user);

	boolean deleteUser(int id);

	Optional<User> getUserByEmail(String email);

	List<User> getUsers(SortOrder sort);

	List<Account> getUserAccounts(int userId);

}
