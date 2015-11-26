package com.laser.domain.presenters.subscribers;

import com.laser.domain.entities.LoginResponse;
import com.laser.domain.views.LoginView;

/**
 * Created by sumitbhatia on 18/11/2015.
 */
public class LoginSubscriber<View extends LoginView> extends BaseUseCaseSubscriber<LoginResponse> {
    protected final View loginView;

    public LoginSubscriber(View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onStart() {
        loginView.showProgress();
    }

    @Override
    public void onError(Throwable e) {
        loginView.hideProgress();
        loginView.onError(e.getMessage());
    }

    @Override
    public void onNext(LoginResponse s) {
        loginView.goToProfile();
    }
}
