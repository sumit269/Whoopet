package com.laser.domain.interactors;

import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

public class LoginUseCase extends SessionUseCase<String> {
    private String username, password;

    @Inject
    public LoginUseCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(iSessionRepository, subscribeOn, observeOn);
    }

    public void doLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected Observable<String> buildUseCaseObservable() {
        return iSessionRepository.askForLogin(username, password);
    }
}
