package ui.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.laser.whoopet.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import di.ApplicationComponent;
import fragments.BaseFragment;
import navigation.Navigator;
import utils.WhoopetApplication;

/**
 * Created by SumitBhatia on 7/06/15.
 */
@EActivity
public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected WhoopetApplication mApp;

    @Inject
    Navigator navigator;

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */


    @AfterInject
    protected void init() {
        getApplicationComponent().inject(this);
    }

    @AfterViews
    protected void initViews() {
    }

    public ApplicationComponent getApplicationComponent() {
        return ((WhoopetApplication) getApplication()).getApplicationComponent();
    }

    public void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, "BaseFragment")
                    .commit();
        }
    }

    public void replaceFragment(Fragment fragment, String tag) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .commit();
        }
    }

    public void addFragment(Fragment fragment) {
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, "BaseFragment")
                .commit();
    }

    public void addFragment(Fragment fragment, String tag) {
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, tag)
                .commit();
    }

    public void addFragmentToStack(Fragment fragment, String tag) {
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(tag)
                .commit();
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

    public void startActivity(Class<BaseFragmentActivity> fragmentClass){
        Intent intent = new Intent(this, fragmentClass);
        startActivity(intent);
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
