package com.darren.optimize.day01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 编译时期就知道的，重载 invokevirtual
        add(1,2);
        // 运行时期才能确定要调用哪个方法，重写 invokevirtual
        Person person = new Teacher();
        person.speak();

        int num1 = 100;
        int num2 = 200;
        int sum = add(num1, num2);
        System.out.println("sum = "+sum);
    }

    public int add(int a, int b){
        return a + b;
    }

    public  void add(double a, double b){

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
}
