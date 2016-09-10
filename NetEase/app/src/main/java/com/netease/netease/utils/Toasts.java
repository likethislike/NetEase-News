package com.netease.netease.utils;

import android.widget.Toast;

import com.netease.netease.controller.app.NetEaseApp;

/**
 * Created by dllo on 16/9/10.
 * Toast的工具类
 */
public final class Toasts {
    private Toasts(){
    }
    private static boolean isDebug = true;

    public static void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(NetEaseApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    public static void longMsg(String msg){
        Toast.makeText(NetEaseApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
