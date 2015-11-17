package com.laser.domain.repository;

import rx.Observable;

public interface ISessionRepository {
    Observable<String> askForLogin(String username, String password);

//    Observable<String> askForSignUp(User user);
//
//    Observable<User> askForUserLogged();
//
//    Observable<String> askForUpdateLoggedUser(User user);

    Observable<String> askForLogout();
}