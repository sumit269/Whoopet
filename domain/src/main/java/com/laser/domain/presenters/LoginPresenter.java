package com.laser.domain.presenters;

import com.laser.domain.interactors.LoginUseCase;
import com.laser.domain.views.LoginView;

import javax.inject.Inject;

public class LoginPresenter implements Presenter<LoginView> {
    private final LoginUseCase loginUseCase;
    private LoginView loginView;

    @Inject
    public LoginPresenter(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public void attachView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void doLogin(String username, String password) {
        loginUseCase.doLogin(username, password);
//        loginUseCase.execute(new BaseCredentialsSubscriber<LoginView>(loginView) {
//        });
    }

    @Override
    public void destroy() {
        loginUseCase.unsubscribe();
    }
}