package ui;

import org.androidannotations.annotations.EActivity;

import ui.base.BaseFragmentActivity;

/**
 * Created by SumitBhatia on 8/06/15.
 */
@EActivity
public class MainActivity extends BaseFragmentActivity {

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
