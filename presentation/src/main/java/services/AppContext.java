package services;

public class AppContext {
    private static IApplication application;
    private AppContext(){}

    public static void init(IApplication app){
        application = app;
    }

    public static IApplication getInstance(){
        return application;
    }
}