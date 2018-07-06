package fr.bank.interview.service;

import fr.bank.interview.domain.User;
import fr.bank.interview.exception.AccountDoesNotExistException;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;

public class UserServiceTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User(1, "Yani", "Idoughi", 26, "Test", "065251541", "yani.idoughi@gmail.com");
	}

    @Test
    public void testAddUser() {
        User addedUser = new UserService().addUser(user);
        checkUser(addedUser);
    }
    
    @Test
    public void testUpdateUser() throws AccountDoesNotExistException {
    	user.setFirstName("updated");
    	thrown.expect(AccountDoesNotExistException.class);
    	User updatedUser = new UserService().updateUser(user);
    }
    
    private void checkUser(User actualUser) {
        assertEquals(user.getId(), actualUser.getId());
        assertEquals(user.getFirstName(), actualUser.getFirstName());
        assertEquals(user.getLastName(), actualUser.getLastName());
        assertEquals(user.getEmail(), actualUser.getEmail());
        assertEquals(user.getAge(), actualUser.getAge());
        assertEquals(user.getAddress(), actualUser.getAddress());
        assertEquals(user.getPhoneNumber(), actualUser.getPhoneNumber());
        assertEquals(user.getAccounts(), actualUser.getAccounts());
    }
}
