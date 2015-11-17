package com.laser.domain.interactors;

import com.laser.domain.entities.User;
import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

public class UpdateUserCase extends SessionUseCase<String> {
    private User user;

    @Inject
    public UpdateUserCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(iSessionRepository, subscribeOn, observeOn);
    }

    public void setUserToUpdate(User user) {
        this.user = user;
    }

    @Override
    protected Observable<String> buildUseCaseObservable() {
//        return sessionRepository.askForLogout(user);
        return null;
    }
}
