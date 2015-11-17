package utils;

import android.app.Application;
import android.os.StrictMode;

import com.laser.whoopet.BuildConfig;

import di.ApplicationComponent;
import di.ApplicationModule;
import di.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * Created by SumitBhatia on 9/06/15.
 */
public class WhoopetApplication extends Application {

    public static final String APPLICATION_ID = "OVFQFTjcB8bl3gujXVAKm46yeTN1IaXPyED4ZGyw";
    public static final String CLIENT_KEY = "PD2BcHaEtyo4Tg59f3KCWbsSCWl4Y9RUT0kAfFTM";

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeathOnNetwork()
                    .build());
        }
    }

    private void initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
