package com.laser.views;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.laser.whoopet.views.R;

/**
 * Created by SumitBhatia on 17/07/15.
 */
public class EditTextView extends FrameLayout {

    TextView txtInputText;
    EditText eTxtValue;

    public EditTextView(Context context) {
        super(context);
    }

    public EditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_edittextview, this);

        txtInputText = (TextView) findViewById(R.id.txtLabel);
        eTxtValue = (EditText) findViewById(R.id.etxtValue);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EditTextView, 0, 0);
        try {
            txtInputText.setCompoundDrawablesWithIntrinsicBounds(a.getDrawable(R.styleable.EditTextView_labelDrawable), null, null, null);
            txtInputText.setText(a.getString(R.styleable.EditTextView_labelText));
            eTxtValue.setHint(a.getString(R.styleable.EditTextView_customHint));
        } finally {
            a.recycle();
        }
    }

    public EditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public String getText() {
        return eTxtValue.getText().toString();
    }

    public void setLabelText(String text) {
        txtInputText.setText(text);
    }

    public void setLabelText(int textId) {
        txtInputText.setText(textId);
    }

    public void setDrawable(Drawable resId) {
        txtInputText.setCompoundDrawablesWithIntrinsicBounds(resId, null, null, null);
    }

}
