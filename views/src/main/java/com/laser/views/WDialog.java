package com.laser.views;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by SumitBhatia on 27/07/15.
 */
public class WDialog extends AlertDialog {

    enum DialogType {
        SINGLE_OPTION_INFORMATION_DIALOG,
        SINGLE_OPTION_LIST_DIALOG,
        CONFIRMATION_DIALOG,
    }

    DialogType dialogType;

    public WDialog(Context context) {
        super(context);
    }

    public WDialog(Context context, int theme) {
        super(context, theme);
    }

    protected WDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.setContentView(R.layout.alert_dialog_view);
    }

    public void setDialogType(DialogType type) {
        this.dialogType = type;
    }

    public DialogType getDialogType() {
        return dialogType;
    }
}
