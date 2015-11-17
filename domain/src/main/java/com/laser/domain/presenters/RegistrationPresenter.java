package com.laser.domain.presenters;

import com.laser.domain.entities.User;
import com.laser.domain.interactors.SignUpUseCase;
import com.laser.domain.views.RegistrationView;

import javax.inject.Inject;

public class RegistrationPresenter implements Presenter<RegistrationView> {
    private final SignUpUseCase singUpUseCase;
    private RegistrationView signUpView;

    @Inject
    public RegistrationPresenter(SignUpUseCase singUpUseCase) {
        this.singUpUseCase = singUpUseCase;
    }

    @Override
    public void attachView(RegistrationView signUpView) {
        this.signUpView = signUpView;
    }

    @Override
    public void destroy() {
        singUpUseCase.unsubscribe();
    }

    public void doSignUp(User user) {
        singUpUseCase.setUser(user);
//        singUpUseCase.execute(new BaseCredentialsSubscriber<SignUpView>(signUpView){});
    }
}
