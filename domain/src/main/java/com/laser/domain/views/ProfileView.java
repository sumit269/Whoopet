package com.laser.domain.views;

public interface ProfileView extends BaseView {
    void showProgress();
    void hideProgress();
    void onError(String message);
}
