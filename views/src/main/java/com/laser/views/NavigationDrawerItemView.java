package com.laser.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SumitBhatia on 26/07/15.
 */
public class NavigationDrawerItemView extends FrameLayout {

    private Context mContext;

    private ImageView navItemIcon;
    private ImageView navItemNotificationIcon;
    private TextView navItemText;
    private Class intentClass;

    public NavigationDrawerItemView(Context context) {
        super(context);
    }

    public NavigationDrawerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationDrawerItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.navigation_menu_item, this, false);
        navItemIcon = (ImageView) findViewById(R.id.nav_item_icon);
        navItemNotificationIcon = (ImageView) findViewById(R.id.nav_item_notification);
        navItemText = (TextView) findViewById(R.id.nav_item_text);
    }

    public void setText(String text) {
        navItemText.setText(text);
    }

    public void setNotificationIconId(int resId) {
        navItemNotificationIcon.setImageDrawable(mContext.getResources().getDrawable(resId));
    }

    public void setIconId(int resId) {
        navItemIcon.setImageDrawable(mContext.getResources().getDrawable(resId));
    }

    public void setNavMenuClickListener(OnClickListener onClickListener) {
        this.setOnClickListener(onClickListener);
    }

}
