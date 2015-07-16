package activities;

import android.content.Intent;
import android.os.Bundle;

import com.laser.breedup.R;

import activities.base.BaseFragmentActivity;

public class SplashActivity extends BaseFragmentActivity {

    private static final int DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Thread() {

            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(DURATION);
                    } catch (InterruptedException e) {
                    } finally {
                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

        }.start();

    }

    @Override
    protected int getFragmentLayoutId() {
        return 0;
    }

}
