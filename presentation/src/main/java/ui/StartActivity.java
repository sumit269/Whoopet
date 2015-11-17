package ui;

import android.os.Bundle;

import ui.base.BaseFragmentActivity;
import ui.login.LoginFragment;

//import com.parse.ParseObject;

/**
 * Created by SumitBhatia on 8/06/15.
 */
public class StartActivity extends BaseFragmentActivity {


    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new LoginFragment());
//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();
    }


}
