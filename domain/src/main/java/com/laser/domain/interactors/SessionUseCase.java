package com.laser.domain.interactors;

import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class SessionUseCase<T> {
    protected final ISessionRepository iSessionRepository;
    private final SubscribeOn subscribeOn;
    private final ObserveOn observeOn;
    private Subscription subscription = Subscriptions.empty();

    protected SessionUseCase(ISessionRepository iSessionRepository, SubscribeOn subscribeOn, ObserveOn observeOn) {
        this.iSessionRepository = iSessionRepository;
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    public void execute(Subscriber<T> subscriber) {
        subscription = buildUseCaseObservable()
                .subscribeOn(subscribeOn.getScheduler())
                .observeOn(observeOn.getScheduler())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract Observable<T> buildUseCaseObservable();
}
