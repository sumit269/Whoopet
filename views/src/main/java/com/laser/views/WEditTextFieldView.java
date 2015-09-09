package com.laser.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.laser.whoopet.views.R;

/**
 * Created by SumitBhatia on 26/07/15.
 */
public class WEditTextFieldView extends FrameLayout {

    private EditText etxt_value;
    private ImageView icon_error;

    public WEditTextFieldView(Context context) {
        super(context);
    }

    public WEditTextFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.custom_edittext_view, this, false);
        etxt_value = (EditText) findViewById(R.id.textValue);
        icon_error = (ImageView) findViewById(R.id.imgError);
        setErrorIconVisibility(false);
    }

    public WEditTextFieldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextValue(String value) {
        etxt_value.setText(value);
    }

    public void setErrorIcon(Drawable drawable) {
        icon_error.setImageDrawable(drawable);
    }

    public void setErrorIconVisibility(boolean isVisible) {
        icon_error.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    public void setTextValueDrawable(Drawable drawable) {
        etxt_value.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    public boolean getErrorIconVisibility() {
        if (View.VISIBLE == icon_error.getVisibility()) {
            return true;
        }
        return false;
    }

    public String getTextValue() {
        return etxt_value.getText().toString();
    }


}
