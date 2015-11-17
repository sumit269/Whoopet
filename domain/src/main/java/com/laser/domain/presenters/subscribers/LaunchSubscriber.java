package com.laser.domain.presenters.subscribers;

import com.laser.domain.views.LaunchView;

/**
 * Created by sumitbhatia on 2/11/2015.
 */
public class LaunchSubscriber extends BaseUseCaseSubscriber<String> {
    private final LaunchView launchView;

    public LaunchSubscriber(LaunchView launchView) {
        this.launchView = launchView;
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(String user) {
        launchView.goToProfile();
    }
}
