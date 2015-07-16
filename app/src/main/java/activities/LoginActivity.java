package activities;

import android.os.Bundle;

import com.laser.breedup.R;
import com.parse.ParseObject;

import activities.base.BaseFragmentActivity;

/**
 * Created by SumitBhatia on 8/06/15.
 */
public class LoginActivity extends BaseFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }

    @Override
    protected int getFragmentLayoutId() {
        return 0;
    }
}
