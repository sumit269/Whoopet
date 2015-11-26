package com.laser.data.repositories;

import android.content.Context;

import com.laser.data.net.RestApi;
import com.laser.domain.entities.LoginResponse;
import com.laser.domain.repository.ISessionRepository;
import com.laser.whoopet.data.R;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

public class SessionDataRepository implements ISessionRepository {
    private final RestApi restApi;
    //    private final Persistence persistence;
    private final Context context;

    @Inject
    public SessionDataRepository(Context context, RestApi restApi) {
        this.context = context;
        this.restApi = restApi;
    }

    @Override
    public Observable<LoginResponse> askForLogin(String username, String password) {
//        return restApi.login(username, password).map(new Func1<Credentials, String>() {
//            @Override
//            public String call(Credentials credentials) {
////                persistence.save(Credentials.class.getName(), credentials);
//                return context.getString(R.string.success);
//            }
//        });
        return null;
    }

//    @Override
//    public Observable<User> askForUserLogged() {
//        Credentials credentials = persistence.retrieve(Credentials.class.getName(), Credentials.class);
//        if (credentials == null) return notLoggedUserError();
//
//        return restApi.currentSession(credentials.getSessionToken());
//    }
//
//    @Override
//    public Observable<String> askForUpdateLoggedUser(User user) {
//        Credentials credentials = persistence.retrieve(Credentials.class.getName(), Credentials.class);
//        if (credentials == null) return notLoggedUserError();
//
//        String token = credentials.getSessionToken();
//        String objectId = credentials.getObjectId();
//
//        return restApi.update(token, objectId, user).map(new Func1<JsonObject, String>() {
//            @Override
//            public String call(JsonObject jsonObject) {
//                return context.getString(R.string.success);
//            }
//        });
//    }
//
//    @Override
//    public Observable<String> askForSignUp(User user) {
//        return restApi.signUp(user).map(new Func1<Credentials, String>() {
//            @Override
//            public String call(Credentials credentials) {
//                persistence.save(Credentials.class.getName(), credentials);
//                return context.getString(R.string.success);
//            }
//        });
//    }

    @Override
    public Observable<String> askForLogout() {
//        Credentials credentials = persistence.retrieve(Credentials.class.getName(), Credentials.class);
//        if (credentials == null) return notLoggedUserError();
//
//        persistence.delete(Credentials.class.getName());
        return Observable.just(context.getString(R.string.success));
    }

    private <T> Observable<T> notLoggedUserError() {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onError(new RuntimeException(context.getString(R.string.not_user_logged)));
            }
        });
    }
}
