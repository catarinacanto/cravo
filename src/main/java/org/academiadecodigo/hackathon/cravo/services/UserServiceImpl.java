package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserServiceImpl extends AbstractService<User> {
	
	
	public UserServiceImpl(EntityManagerFactory emf) {
		super(emf, User.class);
	}
	
	
	public boolean authenticate(String username, String password) {
		
		EntityManager em = emf.createEntityManager();
		
		return password.equals(em.find(User.class, username).getPassword());
	}
	
	
	public boolean register(User user) {
		
		if (user.getUsername() == null) {
			save(user);
			return true;
		}
		
		return false;
	}
	
	

}
