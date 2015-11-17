package com.laser.domain.presenters;

import com.laser.domain.interactors.GetUserUseCase;
import com.laser.domain.views.GetUserView;

import javax.inject.Inject;

public class GetUserPresenter implements Presenter<GetUserView> {
    private final GetUserUseCase getUserUseCase;

    @Inject
    public GetUserPresenter(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @Override
    public void attachView(final GetUserView getUserView) {
//        getUserUseCase.execute(
//                new BaseProfileSubscriber<GetUserView, User>(getUserView) {
//            @Override
//            public void onNext(User user) {
//                getUserView.hideProgress();
//                getUserView.onSuccess(user);
//            }
//        }
//        );
    }

    @Override
    public void destroy() {
        getUserUseCase.unsubscribe();
    }
}
