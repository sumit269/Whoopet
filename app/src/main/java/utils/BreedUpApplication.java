package utils;

import android.app.Application;

import com.laser.breedup.BuildConfig;

import timber.log.Timber;

/**
 * Created by SumitBhatia on 9/06/15.
 */
public class BreedUpApplication extends Application {

    public static final String APPLICATION_ID = "OVFQFTjcB8bl3gujXVAKm46yeTN1IaXPyED4ZGyw";
    public static final String CLIENT_KEY = "PD2BcHaEtyo4Tg59f3KCWbsSCWl4Y9RUT0kAfFTM";

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }


}
