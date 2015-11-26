package ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.laser.domain.presenters.LoginPresenter;
import com.laser.domain.views.LoginView;
import com.laser.whoopet.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import butterknife.OnClick;
import ui.base.BaseFragment;
import ui.base.BaseFragmentActivity;
import ui.register.RegisterFragment;


/**
 * Created by SumitBhatia on 9/06/15.
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment implements LoginView {

    @Inject
    LoginPresenter loginPresenter;

    @ViewById(R.id.btn_login)
    Button btnLogin;

    @ViewById(R.id.login_username)
    EditText etxtUserName;

    @ViewById(R.id.login_password)
    EditText etxtPassword;

    @Override
    protected String getPageTitle() {
        return "Test";
    }

    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        loginPresenter.attachView(this);
    }

    @Override
    protected void initAdditionalViewSettings(Bundle savedInstanceState) {

    }


    @OnClick(R.id.btn_login)
    protected void onLoginClicked() {
        if (validateInput()) {
            loginPresenter.doLogin(etxtUserName.getText().toString(), etxtPassword.getText().toString());
        }
    }

    @OnClick(R.id.btn_register)
    protected void onRegisterClicked() {
        goToRegistration();
    }


    private boolean validateInput() {
        if (TextUtils.isEmpty(etxtUserName.getText())) {
            etxtUserName.setError("Please enter username");
            return false;
        } else if (TextUtils.isEmpty(etxtPassword.getText())) {
            etxtPassword.setError("Please enter password");
            return false   ;
        }
        return false;
    }

    @Override
    public void goToProfile() {

    }

    @Override
    public void goToRegistration() {
        RegisterFragment fragment = new RegisterFragment();
        ((BaseFragmentActivity) getActivity()).replaceFragment(fragment);
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
        goToProfile();
    }
}
