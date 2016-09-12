package com.asuka.android.asukaandroid.demo;

import android.content.Context;

import com.asuka.android.asukaandroid.AsukaAndroid;
import com.asuka.android.asukaandroid.EgojitApplication;
import com.asuka.android.asukaandroid.orm.app.AsukaOrmApplication;

/**
 * Created by egojit on 16/9/9.
 */
public class DemoApplication extends AsukaOrmApplication {


    public DemoApplication(Context context) {
        super(context);
    }

    public DemoApplication(){
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AsukaAndroid.Ext.init(this);
        AsukaAndroid.Ext.setDebug(true);
    }
}
