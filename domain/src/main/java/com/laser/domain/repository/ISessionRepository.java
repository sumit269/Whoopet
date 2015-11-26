package com.laser.domain.repository;

import com.laser.domain.entities.LoginResponse;
import rx.Observable;

public interface ISessionRepository {
    Observable<LoginResponse> askForLogin(String username, String password);

//    Observable<String> askForSignUp(User user);
//
//    Observable<User> askForUserLogged();
//
//    Observable<String> askForUpdateLoggedUser(User user);

    Observable<String> askForLogout();
}