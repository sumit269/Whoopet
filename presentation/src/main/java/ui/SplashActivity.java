package ui;

import com.laser.whoopet.R;

import org.androidannotations.annotations.EActivity;

import ui.base.BaseFragmentActivity;
import ui.login.LoginActivity_;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseFragmentActivity {

    private static final int DURATION = 3000;

    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        new Thread() {

            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(DURATION);
                    } catch (InterruptedException e) {
                    } finally {
                        LoginActivity_.intent(SplashActivity.this).start();
                        finish();
                    }
                }
            }

        }.start();
    }
}
