package com.asuka.android.asukaandroid;

import android.app.Application;
import android.content.Context;

import com.asuka.android.asukaandroid.comm.AppManager;

/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask:基础Application
 */
public class EgojitApplication extends Application {

    public EgojitApplication(){
        super();
    }

    private static AppManager appManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appManager=AppManager.getAppManager();
    }


    public AppManager getAppManager(){
        return appManager;
    }


    public EgojitApplication(Context context){
        this.attachBaseContext(context);
    }



}
