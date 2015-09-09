package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Button;

import com.laser.breedup.R;

import activities.base.BaseFragmentActivity;
import butterknife.InjectView;
import butterknife.OnClick;
import com.laser.views.EditTextView;

/**
 * Created by SumitBhatia on 9/06/15.
 */
public class LoginFragment extends BaseFragment {

    @InjectView(R.id.btn_login)
    Button btnLogin;

    @InjectView(R.id.login_username)
    EditTextView etxtUserName;

    @InjectView(R.id.login_password)
    EditTextView etxtPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected String getPageTitle() {
        return null;
    }

    @OnClick(R.id.btn_login)
    protected void onLoginClicked() {
        if (validateInput()) {


        }
    }

    @OnClick(R.id.btn_register)
    protected void onRegisterClicked() {
        Fragment fragment = new RegisterFragment();
        ((BaseFragmentActivity) getActivity()).replaceFragment(fragment);
    }


    private boolean validateInput() {
        if (etxtUserName.getText() != null && etxtUserName.getText().length() != 0 &&
                etxtPassword.getText() != null && etxtPassword.getText().length() != 0) {
            return true;
        }
        return false;
    }
}
