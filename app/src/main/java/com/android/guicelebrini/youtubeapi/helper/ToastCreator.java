package com.android.guicelebrini.youtubeapi.helper;

import android.content.Context;
import android.widget.Toast;

public class ToastCreator {

    public static Toast toast;

    public static void shortShow(String message, Context context){
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void longShow(String message, Context context){
        toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

}
