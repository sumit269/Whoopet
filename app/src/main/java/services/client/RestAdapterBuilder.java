package services.client;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;
import utils.GsonProvider;

public class RestAdapterBuilder {

    RestAdapter.Builder baseBuilder;

    public RestAdapterBuilder() {
        baseBuilder = new RestAdapter.Builder();
        baseBuilder.setLog(getLog());
        baseBuilder.setLogLevel(RestAdapter.LogLevel.FULL);
    }

    public static RestAdapterBuilder restAdapterBuilder() {
        return new RestAdapterBuilder();
    }

    public RestAdapterBuilder setClient(Client client) {
        baseBuilder.setClient(client);
        return this;
    }

    public RestAdapterBuilder setRequestInterceptor(RequestInterceptor interceptor) {
        baseBuilder.setRequestInterceptor(interceptor);
        return this;
    }

    public RestAdapterBuilder setEndPoint(String endPoint) {
        baseBuilder.setEndpoint(endPoint);
        return this;
    }

    public RestAdapterBuilder setWrapperClass(Type type) {
        // For no response services calls (code 204)
        if (type != null) {
            baseBuilder.setConverter(getGsonConverter(type));
        }
        return this;
    }

    public RestAdapterBuilder setConverter(Converter converter) {
        if (converter != null) {
            baseBuilder.setConverter(converter);
        }
        return this;
    }

    private Converter getGsonConverter(final Type wrapperType) {
        Gson gson = GsonProvider.getDefaultGson();
        return new GsonConverter(gson) {
            @Override
            public Object fromBody(TypedInput body, Type type) throws ConversionException {
                return super.fromBody(body, wrapperType);
            }
        };
    }

    public ServiceInterface build() {
        return baseBuilder.build().create(ServiceInterface.class);
    }

    private RestAdapter.Log getLog() {
        RestAdapter.Log log = new RestAdapter.Log() {
            public void log(String message) {
//                if (BuildConfig.DEBUG) {
//                    Log.d("Telstra24x7", message);
//                }
            }
        };
        return log;
    }
}
