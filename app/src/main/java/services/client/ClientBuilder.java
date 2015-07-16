package services.client;

import retrofit.client.Client;

public interface ClientBuilder {

    public ClientBuilder connectionTimeout(int timeout);

    public ClientBuilder socketTimeout(int timeout);

    public ClientBuilder setProxy(String host, int port);

    public Client build();
}
