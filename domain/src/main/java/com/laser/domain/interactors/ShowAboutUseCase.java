package com.laser.domain.interactors;

import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by sumitbhatia on 7/11/2015.
 */
public class ShowAboutUseCase extends SessionUseCase<Void> {
    private String username, password;

    @Inject
    public ShowAboutUseCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(iSessionRepository, subscribeOn, observeOn);
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {
//        return iSessionRepository.askForLogin(username, password);
        return null;
    }
}
