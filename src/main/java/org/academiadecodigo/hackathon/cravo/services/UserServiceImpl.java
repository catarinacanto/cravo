package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.user.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

	private Map<String, User> users = new HashMap<String, User>();

	public boolean authenticate(String username, String password) {
		return users.containsKey(username) && users.get(username).getPassword().equals(password);
	}

	public void add(User user) {
		if (!users.containsKey(user)) {
			users.put(user.getUsername(), user);
		}
	}

	public User findByName(String username) {
		return users.get(username);
	}

	public int count() {
		return users.size();
	}
}
