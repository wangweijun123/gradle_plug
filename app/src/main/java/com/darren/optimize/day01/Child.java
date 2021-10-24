package com.darren.optimize.day01;

import android.util.Log;

public class Child extends HelloWorld{
    public static String name = "Darren";

    static {
        Log.e("TAG","Hello");
        name = "New Name";
    }
}
