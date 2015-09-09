package activities.base;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.laser.breedup.R;

import utils.BreedUpApplication;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected BreedUpApplication mApp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Fragment fragment = getFragment();
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment, "BaseFragment")
                    .commit();
        }
    }

    protected abstract Fragment getFragment();

    public void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, "BaseFragment")
                    .commit();
        }
    }

    private ProgressDialog progressDialog;

    public void showProgressDialog(Context context, String title, String message, boolean inDeterminate, boolean isCancelable) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(context, title, message, inDeterminate, isCancelable);
        }
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

    public void showAlertDialog(Context context, String title, String message, boolean isCancelable) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setTitle(title)
                .setCancelable(isCancelable);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void setActionBarTitle(Context context, String title) {
        if (((BaseFragmentActivity) context).getSupportActionBar() != null) {
            ((BaseFragmentActivity) context).getSupportActionBar().setTitle(title);
        }
    }

    public void setActionBarTitle(Context context, int title) {
        if (((BaseFragmentActivity) context).getSupportActionBar() != null) {
            ((BaseFragmentActivity) context).getSupportActionBar().setTitle(title);
        }
    }

    public void hideKeyboard() {
        try {
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showKeyboard() {
        try {
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
