package com.asuka.android.asukaandroid;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.asuka.android.asukaandroid.comm.utils.LogUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask: 所有activity继承这个Activity
 */
public class AsukaActivity extends AppCompatActivity {

    private SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AsukaAndroid.app().getAppManager().addActivity(this);
        // 修改状态栏颜色，4.4+生效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus();
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(android.R.color.black);//通知栏所需颜色
        AsukaAndroid.view().inject(this);//启动注入
        LogUtil.d("activity创建,并且注入");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AsukaAndroid.app().getAppManager().finishActivity(this);
    }

    public void setStatusBarTintResource(int resource){
        tintManager.setStatusBarTintResource(resource);//通知栏所需颜色
    }


    @TargetApi(19)
    protected void setTranslucentStatus() {
        Window window = getWindow();
        // Translucent status bar
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // Translucent navigation bar
//        window.setFlags(
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

}
