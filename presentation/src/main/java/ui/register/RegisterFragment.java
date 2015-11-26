package ui.register;

import android.os.Bundle;

import com.laser.whoopet.R;

import org.androidannotations.annotations.EFragment;

import ui.base.BaseFragment;

/**
 * Created by SumitBhatia on 9/06/15.
 */
@EFragment(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment {

    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    @Override
    protected void initAdditionalViewSettings(Bundle savedInstanceState) {

    }

    @Override
    protected String getPageTitle() {
        return "Register";
    }

}
