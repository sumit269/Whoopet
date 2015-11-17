package ui.about;

import com.laser.domain.views.AboutView;

import ui.base.BaseFragmentActivity;

/**
 * Created by sumitbhatia on 7/11/2015.
 */
public class AboutActivity extends BaseFragmentActivity implements AboutView {


    @Override
    protected void init() {
        super.init();
        getApplicationComponent().inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
    }
}
