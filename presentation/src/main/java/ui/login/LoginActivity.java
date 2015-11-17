package ui.login;

import com.laser.whoopet.R;

import org.androidannotations.annotations.EActivity;

import ui.base.BaseFragmentActivity;

/**
 * Created by sumitbhatia on 5/11/2015.
 */
@EActivity(R.layout.activity_base)
public class LoginActivity extends BaseFragmentActivity {

    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);

    }

    @Override
    protected void initViews() {
        super.initViews();
        LoginFragment loginFragment = LoginFragment_.builder().build();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, loginFragment, "BaseFragment")
                .commit();
//        addFragment(LoginFragment_.builder().build());

    }

}
