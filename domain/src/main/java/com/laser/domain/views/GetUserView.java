package com.laser.domain.views;

import com.laser.domain.entities.User;

public interface GetUserView extends ProfileView {
    void onSuccess(User user);
}
