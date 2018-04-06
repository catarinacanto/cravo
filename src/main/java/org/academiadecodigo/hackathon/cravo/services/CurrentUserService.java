package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.user.User;

public class CurrentUserService implements Service {

    private User currentUser;

    public CurrentUserService(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}
