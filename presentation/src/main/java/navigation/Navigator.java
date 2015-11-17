package navigation;

import android.content.Context;

import javax.inject.Inject;


public class Navigator {
    @Inject
    public void Navigator() {
    }

    public void toLogin(Context context) {
        if (context != null) {

        }
//            Login.intent(context).start();
    }

    public void toProfile(Context context) {
        if (context != null) {
        }
//            ProfileActivity_.intent(context).start();
    }
}
