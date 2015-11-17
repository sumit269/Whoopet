package ui.register;

import com.laser.domain.presenters.RegistrationPresenter;
import com.laser.domain.views.RegistrationView;

import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import ui.base.BaseFragmentActivity;

/**
 * Created by SumitBhatia on 8/06/15.
 */
@EActivity
public class RegisterActivity extends BaseFragmentActivity implements RegistrationView {

    @Inject
    RegistrationPresenter registrationPresenter;

    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
        registrationPresenter.attachView(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
//        addFragment(new RegisterFragment_.FragmentBuilder_().build());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess(String message) {

    }
}
