package fr.bank.interview.service;

import fr.bank.interview.domain.User;
import fr.bank.interview.exception.AccountDoesNotExistException;

public class UserService {
	
	private User user;

    public User addUser(User user) {
    	this.user = user;
        return user;
    }

	public User getUser(int id) {
		return this.user.getId() == id ? this.user : null;
	}

	public User updateUser(User updatedUser) throws AccountDoesNotExistException {
		if (this.user == null) {
			throw new AccountDoesNotExistException("User does not exist");
		}
		if (updatedUser.getId() == this.user.getId()) {
			this.user = updatedUser;
		}
		return this.user;
	}
}
