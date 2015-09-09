package activities;

import android.app.Fragment;
import android.os.Bundle;

import com.laser.breedup.R;
//import com.parse.ParseObject;

import activities.base.BaseFragmentActivity;
import fragments.LoginFragment;

/**
 * Created by SumitBhatia on 8/06/15.
 */
public class StartActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();
    }

    @Override
    protected Fragment getFragment() {
        return new LoginFragment();
    }

}
