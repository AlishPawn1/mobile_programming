package com.bca.mobile_programming.unit_1;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class GeneralUtil {
    private static final int BLACK = 0xFF000000;
    private static final int LIGHT_TEAL = 0xFFE9FFF7;
    private static final int LIGHT_PINK = 0xFF2AEF3;

    public static void showMySnack(View rootLayout, String message, String closeMessage){
        Snackbar snackbar = Snackbar.make(rootLayout, message, Snackbar.LENGTH_LONG);
        snackbar.setTextColor(LIGHT_TEAL);
        snackbar.setBackgroundTint(BLACK);
        snackbar.setActionTextColor(LIGHT_PINK);
        snackbar.setAction(closeMessage, v1 -> snackbar.dismiss());

        snackbar.show();
    }

}
