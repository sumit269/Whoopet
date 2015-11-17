package com.laser.domain.presenters;

import com.laser.domain.interactors.ShowAboutUseCase;
import com.laser.domain.views.AboutView;

import javax.inject.Inject;

/**
 * Created by sumitbhatia on 7/11/2015.
 */
public class AboutPresenter implements Presenter<AboutView> {

    AboutView aboutView;
    ShowAboutUseCase showAboutUseCase;

    @Inject
    AboutPresenter aboutPresenter;

    @Override
    public void attachView(AboutView aboutView) {
        this.aboutView = aboutView;
    }

    @Override
    public void destroy() {
        showAboutUseCase.unsubscribe();
    }
}
