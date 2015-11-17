package com.laser.domain.interactors;

import com.laser.domain.entities.User;
import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

public class SignUpUseCase extends SessionUseCase<String> {
    private User user;

    @Inject
    public SignUpUseCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(iSessionRepository, subscribeOn, observeOn);
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected Observable<String> buildUseCaseObservable() {
        return iSessionRepository.askForLogout();
    }
}
