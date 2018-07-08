package fr.bank.interview.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.List;
import javax.swing.SortOrder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import fr.bank.interview.domain.Account;
import fr.bank.interview.util.Order;
import fr.bank.interview.util.OrderedRunner;

/**
 * 
 * @author yidoughi
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(OrderedRunner.class)
public class AccountServiceTest {

	private static AccountService accountService;

	@BeforeClass
	public static void init() {
		accountService = new AccountService();
	}

	@Test
	@Order(order = 1)
	public void createAccounts() {
		assertTrue(accountService.getAccounts(SortOrder.UNSORTED).size() == 15);
	}

	@Test
	@Order(order = 2)
	public void readAccount() {
		Account account = accountService.findAccountById(5).get();
		assertNotNull(account);
	}

	@Test
	@Order(order = 3)
	public void addAccount() {
		Account account = new Account(1, new Date(), new Date(), 500, 200, 100);
		Account accountAdded = accountService.addAccount(account);
		assertNull(accountAdded);

		account.setId(16);
		accountAdded = accountService.addAccount(account);
		assertNotNull(accountAdded);
	}

	@Test
	@Order(order = 4)
	public void updateAccount() {
		Account account = accountService.findAccountById(2).get();
		account.setBalance(0);
		accountService.updateAccount(account);
		assertTrue(accountService.findAccountById(2).get().getBalance() == 0);
	}

	@Test
	@Order(order = 5)
	public void deleteAccount() {
		accountService.deleteAccount(4, 3);
		assertFalse(accountService.findAccountById(3).isPresent());
		Account account = new Account(3, new Date(), new Date(), 100, 450, 20);
		accountService.addAccount(account);
		accountService.linkAccountToUser(4, 3);
	}

	@Test
	@Order(order = 6)
	public void linkAccountToUser() {
		Account a1 = accountService.linkAccountToUser(3, 10);
		Account a2 = accountService.linkAccountToUser(3, 2);
		Account a3 = accountService.linkAccountToUser(3, 4);
		Account a4 = accountService.linkAccountToUser(3, 5);
		Account a5 = accountService.linkAccountToUser(4, 1);
		Account a6 = accountService.linkAccountToUser(4, 3);
		Account a7 = accountService.linkAccountToUser(4, 7);
		Account a8 = accountService.linkAccountToUser(1, 10);
		assertNotNull(a1);
		assertNotNull(a2);
		assertNotNull(a3);
		assertNotNull(a4);
		assertNotNull(a5);
		assertNotNull(a6);
		assertNotNull(a7);
		assertNotNull(a8);
	}

	@Test
	@Order(order = 7)
	public void findUserAccounts() {
		List<Account> accounts = accountService.getAccountsOfUser(3);
		assertTrue(accounts.size() == 4);
	}

	@Test
	@Order(order = 8)
	public void whidhdrawMonney() {
		Account account = accountService.findAccountById(6).get();
		double max = account.getMaxWithdrawAmount();
		double min = account.getMinWithdrawAmount();
		double balance = account.getBalance();

		account = accountService.whidhdrawMonney(6, max);
		assertTrue(balance - max == account.getBalance());

		account = accountService.whidhdrawMonney(6, max++);
		assertFalse(balance == account.getBalance());

		balance = account.getBalance();

		account = accountService.whidhdrawMonney(6, min);
		assertTrue(balance - min == account.getBalance());

		account = accountService.whidhdrawMonney(6, min);
		assertFalse(balance == account.getBalance());
	}

	@Test
	@Order(order = 9)
	public void depositMonney() {
		Account account = accountService.findAccountById(4).get();
		double balance = account.getBalance();
		account = accountService.depositMoney(4, 100);
		assertTrue(account.getBalance() - balance == 100);
	}

	@Test
	@Order(order = 10)
	public void sumBalance() {
		assertTrue(accountService.getSumAccountsOfUser(4) == 900);
	}

}
