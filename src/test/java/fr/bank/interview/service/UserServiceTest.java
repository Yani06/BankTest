package fr.bank.interview.service;

import fr.bank.interview.domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void testAddUser() {
        User user = new User();
        User addedUser = new UserService().addUser(user);
        assertEquals(user.getId(), addedUser.getId());
        assertEquals(user.getFirstName(), addedUser.getFirstName());
        assertEquals(user.getLastName(), addedUser.getLastName());
        assertEquals(user.getAge(), addedUser.getAge());
        assertEquals(user.getAddress(), addedUser.getAddress());
        assertEquals(user.getPhoneNumber(), addedUser.getPhoneNumber());
        assertEquals(user.getAccounts(), addedUser.getAccounts());
    }
}
