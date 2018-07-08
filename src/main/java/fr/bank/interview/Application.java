package fr.bank.interview;

import javax.swing.SortOrder;

import fr.bank.interview.service.AccountService;
import fr.bank.interview.service.UserService;

/**
 *
 * @author yidoughi
 *
 */
public class Application {
	
	public static void main(String... args) {

		UserService userService = new UserService();
		System.out.println("**************** Users *********** ");
		userService.getUsers(SortOrder.ASCENDING).forEach(user -> System.out.println(user.toString()));

		System.out.println("**************** Accounts *********** ");

		AccountService accountService = new AccountService();
		accountService.getAccounts(SortOrder.DESCENDING).forEach(account -> System.out.println(account.toString()));

		System.out.println("**************** Link accounts to one user *********** ");

		userService.getUserByEmail("yidoughi@neolynk.fr").ifPresent(u -> {
			accountService.linkAccountToUser(u.getId(), 1);
			accountService.linkAccountToUser(u.getId(), 3);
			accountService.linkAccountToUser(u.getId(), 7);
			System.out.println(u.toString());
		});

		accountService.linkAccountToUser(3, 1);
		accountService.linkAccountToUser(3, 2);
		accountService.linkAccountToUser(3, 4);
		accountService.linkAccountToUser(3, 5);

		System.out.println("Sum User 3 = " + accountService.getSumAccountsOfUser(3));
	}
	
}
