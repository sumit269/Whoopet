package com.laser.domain.presenters;

import com.laser.domain.interactors.GetUserUseCase;
import com.laser.domain.presenters.subscribers.LaunchSubscriber;
import com.laser.domain.views.LaunchView;

import javax.inject.Inject;

public class LaunchPresenter implements Presenter<LaunchView> {
    private final GetUserUseCase getUserUseCase;

    @Inject
    public LaunchPresenter(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @Override
    public void attachView(LaunchView launchView) {
        getUserUseCase.execute(new LaunchSubscriber(launchView));
    }

    @Override
    public void destroy() {
        getUserUseCase.unsubscribe();
    }


}
