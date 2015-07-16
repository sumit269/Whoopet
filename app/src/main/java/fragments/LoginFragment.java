package fragments;

import android.widget.Button;
import android.widget.EditText;

import com.laser.breedup.R;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by SumitBhatia on 9/06/15.
 */
public class LoginFragment extends BaseFragment {

    @InjectView(R.id.btn_login)
    Button btnLogin;

    @InjectView(R.id.etxt_username)
    EditText etxtUserName;

    @InjectView(R.id.etxt_password)
    EditText etxtPassword;


    @Override
    protected int setContentLayout() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.btn_login)
    protected void onLoginClicked() {
        if(validateInput()){


        }
    }

    private boolean validateInput() {
        if (etxtUserName.getText() != null && etxtUserName.getText().length() != 0 &&
                etxtPassword.getText() != null && etxtPassword.getText().length() != 0) {
            return true;
        }
        return false;
    }
}
