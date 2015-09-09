package activities;

import android.app.Fragment;

import activities.base.BaseFragmentActivity;
import fragments.RegisterFragment;

/**
 * Created by SumitBhatia on 8/06/15.
 */
public class  RegisterActivity extends BaseFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new RegisterFragment();
    }
}
