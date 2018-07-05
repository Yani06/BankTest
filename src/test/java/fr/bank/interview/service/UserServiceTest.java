package fr.bank.interview.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserServiceTest {

    @Test
    public void testCreateUser() {
        User user = new User();
        assertTrue(new UserService().createUser(user));
    }
}
