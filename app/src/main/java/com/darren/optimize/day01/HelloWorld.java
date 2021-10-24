package com.darren.optimize.day01;

import android.util.Log;

import java.util.concurrent.ExecutionException;

public class HelloWorld {
    public HelloWorld() {
    }

    public final static void main(String[] args) {
        System.out.println("Hello World!");
        Log.e("TAG","xxx");

        try{
            Log.e("TAG","xxx");
            Integer.parseInt("0x01");
            return;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 1, 2 , 答案是 1
            Log.e("TAG","finally");
        }

        // 手 Q 小世界  就是用的 Shadow ClassLoader ListView
        //  ClassLoader -> ListView
        // sdk hotfix 5分钟，20分钟 25分钟，30S ，tinker ，阿里 新包和旧包
    }
}
