package services.client;

import android.content.Context;

//import org.apache.http.cookie.Cookie;

import java.util.HashMap;
import java.util.Map;

import services.ServiceProperties;

/**
 * Created by SumitBhatia on 24/06/15.
 */
public abstract class BaseService {

    protected Context context;
    protected String userName;
//    protected Cookie appCookie;
    protected ServiceProperties properties;

    public BaseService(Context context, ServiceProperties properties, String username
//            , Cookie appCookie
    ) {
        this.context = context;
        this.properties = properties;
        this.userName = username;
//        this.appCookie = appCookie;
    }

    protected ServiceInterface createServices() {
//        return RestAdapter.
        return null;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(ServiceConstants.ACCEPT_HEADER, getAcceptHeader());

        return headers;
    }

    protected abstract String getAcceptHeader();


}
