package ui.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by SumitBhatia on 21/06/15.
 */
public abstract class BaseTrackerActivity extends AppCompatActivity {
    protected abstract String getAppTrackingPageName();


    @Override
    protected void onResume() {
        super.onResume();
    }
}
