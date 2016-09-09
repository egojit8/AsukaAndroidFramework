package com.asuka.asukaandroid.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asuka.android.asukaandroid.AsukaActivity;
import com.asuka.android.asukaandroid.AsukaAndroid;
import com.asuka.android.asukaandroid.view.annotation.ContentView;
import com.asuka.android.asukaandroid.view.annotation.ViewInject;
import com.asuka.asukaandroid.demo.R;

@ContentView(R.layout.activity_main)
public class MainActivity extends AsukaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarTintResource(R.color.colorPrimary);
    }
}
