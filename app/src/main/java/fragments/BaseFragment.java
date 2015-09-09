package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import utils.StringUtils;

public abstract class BaseFragment extends Fragment {
    public BaseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(setContentLayout(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!StringUtils.isNullOrEmptyOrBlank(getPageTitle())) {
            getActivity().setTitle(getPageTitle());
        }
    }

    protected abstract int setContentLayout();

    protected abstract String getPageTitle();

}
