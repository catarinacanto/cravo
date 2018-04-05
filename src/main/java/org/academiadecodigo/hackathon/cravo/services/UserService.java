package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.user.User;

public interface UserService {
	boolean authenticate(String username, String password);

	/**
	 * Adds a new user
	 * @param user the new user to add
	 */
	void add(User user);

	/**
	 * Finds a user by name
	 * @param username the user name used to lookup a user
	 * @return a new User if found, null otherwise
	 */
	User findByName(String username);

	/**
	 * Count the number of existing users
	 * @return the number of users
	 */
	int count();
}
