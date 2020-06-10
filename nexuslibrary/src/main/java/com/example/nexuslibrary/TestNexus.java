package com.example.nexuslibrary;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TestNexus {
    public static String getInfo() {
        return "测试，上传arr到私有maven仓库";
    }

    public static void loadImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).into(iv);
    }
}
