package com.laser.data.net;

import com.google.gson.JsonObject;
import com.laser.domain.entities.User;

import javax.inject.Inject;

import rx.Observable;

public class RestApi {
    private final ApiEndpoints apiEndpoints;

    @Inject
    public RestApi(ApiEndpoints apiEndpoints) {
        this.apiEndpoints = apiEndpoints;
    }

//    public Observable<Credentials> login(String username, String password) {
//        return endpoints.login(username, password);
//    }
//
//    public Observable<Credentials> signUp(User user) {
//        return endpoints.signUp(user);
//    }

    public Observable<User> currentSession(String token) {
        return apiEndpoints.currentSession(token);
    }

    public Observable<JsonObject> update(String token, String objectId, User user) {
        return apiEndpoints.update(token, objectId, user);
    }
}
