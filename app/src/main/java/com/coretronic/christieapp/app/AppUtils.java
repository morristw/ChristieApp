package com.coretronic.christieapp.app;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Morris on 15/2/4.
 */
public class AppUtils {

    public static float getDensity(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }
}