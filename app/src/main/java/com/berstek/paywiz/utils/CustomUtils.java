package com.berstek.paywiz.utils;

import android.widget.EditText;

public class CustomUtils {

    public static boolean editTextEmpty(EditText... args) {

        for (EditText e : args) {
            if (e.getText().length() == 0)
                return true;
        }

        return false;
    }
}
