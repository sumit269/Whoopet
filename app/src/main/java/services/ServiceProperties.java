package services;

import android.content.Context;

public interface ServiceProperties {

    public boolean isDev();

    public boolean isMock();

    public boolean isUat();

    public boolean isPvt();

    public boolean isProd();

    public String getSourceSystem();

    public int getServiceConnectionTimeout();

    public String getBasicAuthUserName();

    public String getBasicAuthPassword();

    public String getCookieAuthenticationServiceHost();

    public Integer getCookieAuthenticationServicePort();

    public boolean isReleaseMode(Context context);

    public String getCookieAuthenticationServiceUrl();
}
