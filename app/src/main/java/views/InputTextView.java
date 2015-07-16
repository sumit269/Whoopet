package views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.laser.breedup.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by SumitBhatia on 20/06/15.
 */
public class InputTextView extends FrameLayout {

    @InjectView(R.id.etxtInputText)
    EditText eTxtInputText;

    public InputTextView(Context context) {
        super(context);
    }

    public InputTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.inputtextview, this);

        ButterKnife.inject(this);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.InputTextView, 0, 0);
        try {
            eTxtInputText.setCompoundDrawablesWithIntrinsicBounds(a.getDrawable(R.styleable.InputTextView_inputTextDrawable), null, null, null);
            eTxtInputText.setHint(a.getString(R.styleable.InputTextView_customHintText));
        } finally {
            a.recycle();
        }
    }

    public InputTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


}
