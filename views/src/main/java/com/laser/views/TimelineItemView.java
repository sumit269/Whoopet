package com.laser.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by SumitBhatia on 26/07/15.
 */
public class TimelineItemView extends RelativeLayout {

    ImageView timelineIcon;
    TextView timelineTextView;

    public TimelineItemView(Context context) {
        super(context);
    }

    public TimelineItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimelineItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.timeline_item_view, this, false);
        timelineIcon = (ImageView) findViewById(R.id.timelineIcon);
        timelineTextView = (TimeLineTextView) findViewById(R.id.timelineText);

    }

    public void setTimelineText(String string) {
        timelineTextView.setText(string);
    }

    public void setTimelineIcon(Drawable drawable) {
        timelineIcon.setImageDrawable(drawable);
    }
}
