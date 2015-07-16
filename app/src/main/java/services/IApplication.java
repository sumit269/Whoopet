package services;

import android.app.Application;

public interface IApplication {

    public Application getContext();

    public ServiceProperties getPropertyUtils();

//    public IServiceManager getServiceManager();

    public IUserAccountManager getUserAccountManager();


}
