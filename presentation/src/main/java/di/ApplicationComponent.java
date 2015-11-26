package di;

import javax.inject.Singleton;

import ui.MainActivity;
import dagger.Component;
import ui.base.BaseFragment;
import ui.SplashActivity;
import ui.base.BaseFragmentActivity;
import ui.login.LoginActivity;
import ui.login.LoginFragment;
import ui.register.RegisterActivity;
import ui.register.RegisterFragment;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseFragmentActivity baseFragmentActivity);

    void inject(BaseFragment baseFragment);

    void inject(LoginFragment loginFragment);

    void inject(RegisterFragment registerFragment);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(RegisterActivity registerActivity);

    void inject(SplashActivity splashActivity);

//    void inject(FragmentLogin fragmentLogin);
//
//    void inject(FragmentSignUp fragmentSignUp);
//
//    void inject(FragmentProfile fragmentProfile);
//
//    void inject(FragmentLogout fragmentLogout);
}
