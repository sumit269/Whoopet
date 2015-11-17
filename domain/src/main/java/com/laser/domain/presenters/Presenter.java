package com.laser.domain.presenters;

import com.laser.domain.views.BaseView;

public interface Presenter<T extends BaseView> {
    void attachView(T view);
    void destroy();
}
