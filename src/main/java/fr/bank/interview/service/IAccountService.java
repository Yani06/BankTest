package fr.bank.interview.service;

import java.util.List;
import java.util.Optional;

import javax.swing.SortOrder;

import fr.bank.interview.domain.Account;


/**
 * 
 * @author yidoughi
 *
 */

public interface IAccountService {

	Account addAccount(Account account);

	Optional<Account> findAccountById(int id);

	Account updateAccount(int accountId, Account account);

	boolean deleteAccount(int userId, int accountId);

	Account linkAccountToUser(int accountId, int userId);

	List<Account> getAccounts(SortOrder sort);

	List<Account> getAccountsOfUser(int userId);

	Account depositMoney(int accountId, double amount);

	Account whidhdrawMonney(int accountId, double amount);

	double getSumAccountsOfUser(int userId);
}
