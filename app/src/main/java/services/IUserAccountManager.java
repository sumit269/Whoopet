package services;

import models.User;

public interface IUserAccountManager {

    public User getCurrentLoggedInUser();

    public void logout(boolean deleteStoredCredentials);

    public void saveUserAccount(User userAccount);
}
