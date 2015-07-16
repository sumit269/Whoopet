package services.client;

import java.util.Map;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by SumitBhatia on 28/06/15.
 */
public interface ServiceInterface<T> {

    @GET("/{url}")
    public Observable<String> get(@Path("url") String url);

    @FormUrlEncoded
    @POST("/{url}")
    public Observable<String> postAsForm(@Path("url") String url, @FieldMap Map postParams);

    @POST("/{url}")
    public Observable<String> postWithBody(@Path("url") String url, @Body Object gsonSerializableObject);

    @FormUrlEncoded
    @PUT("/{url}")
    public Observable<String> putAsForm(@Path("url") String url, @FieldMap Map postParams);

    @POST("/{url}")
    public Observable<String> putWithBody(@Path("url") String url, @Body Object gsonSerializableObject);

    @DELETE("/{url}")
    public Observable<String> delete(@Path("url") String url);

}
