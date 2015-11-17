package com.laser.domain.views;

public interface CredentialsView extends BaseView {
    void showProgress();
    void hideProgress();
    void onError(String message);
    void onSuccess(String message);
}
