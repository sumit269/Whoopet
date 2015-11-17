package com.laser.domain.views;

public interface LogoutView extends ProfileView {
    void onSuccess(String message);
    void goToLogin();
}
