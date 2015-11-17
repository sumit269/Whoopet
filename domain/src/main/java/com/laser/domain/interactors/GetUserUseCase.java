package com.laser.domain.interactors;

import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

public class GetUserUseCase extends SessionUseCase<String> {
    @Inject
    public GetUserUseCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(iSessionRepository, subscribeOn, observeOn);
    }

    @Override
    protected Observable<String> buildUseCaseObservable() {
        return iSessionRepository.askForLogout();
    }
}
