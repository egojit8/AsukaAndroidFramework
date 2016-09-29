package com.asuka.android.asukaandroid.demo;

import android.content.Context;

import com.asuka.android.asukaandroid.AsukaAndroid;
import com.asuka.android.asukaandroid.EgojitApplication;
import com.asuka.android.asukaandroid.demo.model.User;
import com.asuka.android.asukaandroid.orm.AsukaOrmAndroid;
import com.asuka.android.asukaandroid.orm.Configuration;
import com.asuka.android.asukaandroid.orm.app.AsukaOrmApplication;

/**
 * Created by egojit on 16/9/9.
 */
public class DemoApplication extends EgojitApplication {


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
        initDb();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        AsukaOrmAndroid.dispose();
    }

    private void initDb(){
        Configuration.Builder configurationBuilder = new Configuration.Builder(this);
        configurationBuilder.addModelClass(User.class).setDatabaseName("test.db").setDatabaseVersion(1);
        AsukaOrmAndroid.initialize(configurationBuilder.create());
    }
}
