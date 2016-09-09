package com.asuka.android.asukaandroid;

import android.app.Application;
import android.content.Context;

import com.asuka.android.asukaandroid.comm.AppManager;

/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask:基础Application
 */
public class AsukaApplication  extends Application {

    public AsukaApplication(){
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


    public AsukaApplication(Context context){
        this.attachBaseContext(context);
    }



}
