package com.example.library_main;

import android.content.Context;
import android.widget.Toast;

import com.example.library_two.TimeUtil;
import com.example.libraryone.Utils;

public class MainUtil {
    public static void showShortMsg(Context context, String msg) {
        Utils.showToast(context, msg);
    }

    public static void showTime(Context context, String time){
        String s = TimeUtil.computePastTime(time);
        showShortMsg(context, s);
    }

}
