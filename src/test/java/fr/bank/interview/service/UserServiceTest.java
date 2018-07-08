package fr.bank.interview.service;

import fr.bank.interview.domain.User;
import fr.bank.interview.util.Order;
import fr.bank.interview.util.OrderedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import javax.swing.SortOrder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(OrderedRunner.class)
public class UserServiceTest {

	private static UserService userService;

	@BeforeClass
	public static void init() {
		userService = new UserService();
	}

	@Test
	@Order(order = 1)
	public void createUsers() {
		assertTrue(userService.getUsers(SortOrder.UNSORTED).size() == 5);
	}

	@Test
	@Order(order = 2)
	public void readUser() {
		assertTrue(userService.getUserByEmail("cdelmon@neolynk.fr").isPresent());
	}

	@Test
	@Order(order = 3)
	public void addUser() {
		User user = new User(6, "TEST", "TEST", 99, "123456789", "xyz.neolynk.fr", null);
		assertTrue(userService.addUser(user) != null && userService.getUsers(SortOrder.UNSORTED).size() > 5);
	}

	@Test
	@Order(order = 4)
	public void updateUser() {
		User user = userService.getUserByEmail("yidoughi@neolynk.fr").get();
		user.setEmail("yani.idoughi@gmail.com");
		User p = userService.updateUser(user);
		assertTrue(userService.getUserByEmail(p.getEmail()).isPresent());
	}

	@Test
	@Order(order = 5)
	public void deleteUser() {
		User user = userService.getUserByEmail("azer@neolynk.fr").get();
		userService.deleteUser(user.getId());
		assertFalse(userService.getUserByEmail("azer@neolynk.fr").isPresent());

	}
}
