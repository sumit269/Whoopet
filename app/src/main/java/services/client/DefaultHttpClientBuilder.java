package services.client;

import android.content.Context;
import android.text.TextUtils;

import com.laser.breedup.R;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.InputStream;
import java.security.KeyStore;

import retrofit.client.ApacheClient;
import retrofit.client.Client;
import services.ServiceProperties;

public class DefaultHttpClientBuilder implements ClientBuilder {

    DefaultHttpClient client;
    HttpParams httpParams;
    ServiceProperties properties;

    public DefaultHttpClientBuilder(ServiceProperties properties, final Context context) {
        this.properties = properties;
        httpParams = new BasicHttpParams();
        httpParams.setParameter(ClientPNames.HANDLE_REDIRECTS, false);
        this.client = new DefaultHttpClient() {

            @Override
            protected ClientConnectionManager createClientConnectionManager() {
                SchemeRegistry registry = new SchemeRegistry();
                registry.register(new Scheme(ServiceConstants.HTTP, PlainSocketFactory.getSocketFactory(), ServiceConstants.HTTP_PORT));
                registry.register(new Scheme(ServiceConstants.HTTPS, createSslSocketFactory(context), ServiceConstants.HTTPS_PORT));
                return new SingleClientConnManager(getParams(), registry);
            }
        };
        //TODO: SUMIT
//        this.client.addResponseInterceptor(new MobileServicesResponseInterceptor());

        boolean isProduction = properties.isReleaseMode(context) || properties.isPvt();

        if (isProduction || properties.isUat()) {
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(properties.getBasicAuthUserName(), properties.getBasicAuthPassword());
            this.client.getCredentialsProvider().setCredentials(new AuthScope(null, -1), credentials);
            this.client.addRequestInterceptor(new PreemptiveAuth(), 0);
        }
    }

    public static DefaultHttpClientBuilder clientBuilder(ServiceProperties properties, Context context) {
        return new DefaultHttpClientBuilder(properties, context);
    }

    public DefaultHttpClientBuilder connectionTimeout(int timeout) {
        HttpConnectionParams.setConnectionTimeout(httpParams, timeout);
        return this;
    }

    public DefaultHttpClientBuilder socketTimeout(int timeout) {
        HttpConnectionParams.setSoTimeout(httpParams, timeout);
        return this;
    }

    public DefaultHttpClientBuilder setProxy(String host, int port) {
        if (!TextUtils.isEmpty(host)) {
            HttpHost proxy = new HttpHost(host, port);
            httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        }
        return this;
    }

    public Client build() {
        client.setParams(httpParams);
        return new ApacheClient(client);
    }

    private SSLSocketFactory createSslSocketFactory(Context context) {
        if (properties.isUat()) {
            try {
//                KeyStore trusted = KeyStore.getInstance(ServiceConstants.BOUNCY_CASTLE_TRUST_STORE_KEY);
//                InputStream in = context.getResources().openRawResource(R.raw.);
//                try {
//                    trusted.load(in, ServiceConstants.TELSTRA_TRUST_STORE_PW.toCharArray());
//                } finally {
//                    in.close();
//                }
//                SSLSocketFactory uatSslSocketFactory = new SSLSocketFactory(trusted);
//                uatSslSocketFactory.setHostnameVerifier(new AllowAllHostnameVerifier());
//                return uatSslSocketFactory;
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }

        return SSLSocketFactory.getSocketFactory();
    }


}
