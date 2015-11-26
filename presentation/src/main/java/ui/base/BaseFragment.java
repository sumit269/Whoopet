package ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import ui.base.BaseFragmentActivity;
import di.ApplicationComponent;
import navigation.Navigator;
import utils.StringUtils;
@EFragment
public abstract class BaseFragment extends Fragment {

    @Inject
    Navigator navigator;

    private Bundle savedInstanceState;

    public BaseFragment() {
    }

    @AfterInject
    protected void init() {
        getApplicationComponent().inject(this);
    }

    @AfterViews
    protected void initViews() {
        initAdditionalViewSettings(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseFragmentActivity) getActivity()).getApplicationComponent();
    }


//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        if (!StringUtils.isNullOrEmptyOrBlank(getPageTitle())) {
//            getActivity().setTitle(getPageTitle());
//        }
//    }

    protected abstract void initAdditionalViewSettings(Bundle savedInstanceState);

    protected abstract String getPageTitle();

}
