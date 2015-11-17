package di;

import android.content.Context;

import com.laser.data.di.data.DataModule;
import com.laser.data.di.user.UserModule;
import com.laser.data.repositories.SessionDataRepository;
import com.laser.domain.repository.ISessionRepository;
import com.laser.domain.scheduler.ObserveOn;
import com.laser.domain.scheduler.SubscribeOn;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navigation.Navigator;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.WhoopetApplication;

@Module(includes = {DataModule.class, UserModule.class})
public class ApplicationModule {
    private final WhoopetApplication application;

    public ApplicationModule(WhoopetApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    ISessionRepository provideSessionRepository(SessionDataRepository sessionDataRepository) {
        return sessionDataRepository;
    }

    @Singleton
    @Provides
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Singleton
    @Provides
    SubscribeOn provideSubscribeOn() {
        return (new SubscribeOn() {
            @Override
            public Scheduler getScheduler() {
                return Schedulers.newThread();
            }
        });
    }

    @Singleton
    @Provides
    ObserveOn provideObserveOn() {
        return (new ObserveOn() {
            @Override
            public Scheduler getScheduler() {
                return AndroidSchedulers.mainThread();
            }
        });
    }
}
