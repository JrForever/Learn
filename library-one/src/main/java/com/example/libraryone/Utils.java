package com.example.libraryone;

import android.content.Context;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Utils {
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
