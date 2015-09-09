package com.laser.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by SumitBhatia on 27/07/15.
 */
public class TimeLineTextView extends TextView {
    public TimeLineTextView(Context context) {
        super(context);
    }

    public TimeLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeLineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setText(styleText(this.getText().toString()));
    }

    private String styleText(String textValue) {
        // Stylise text
        return textValue;
    }
}
