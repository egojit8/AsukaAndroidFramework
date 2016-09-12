package com.asuka.android.asukaandroid;

import android.content.Context;

import com.asuka.android.asukaandroid.view.ViewInjector;
import com.asuka.android.asukaandroid.view.ViewInjectorImpl;

import java.lang.reflect.Method;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask: 任务控制中心, http, image, db, view注入等接口的入口.
 * 需要在在application的onCreate中初始化: AsukaAndroid.Ext.init(this);
 */
public final class AsukaAndroid {

    public static boolean isDebug() {
        return Ext.debug;
    }

    public static EgojitApplication app() {
        if (Ext.app == null) {
            try {
                // 在IDE进行布局预览时使用
                Class<?> renderActionClass = Class.forName("com.android.layoutlib.bridge.impl.RenderAction");
                Method method = renderActionClass.getDeclaredMethod("getCurrentContext");
                Context context = (Context) method.invoke(null);
                Ext.app = new EgojitApplication(context);
            } catch (Throwable ignored) {
                throw new RuntimeException("please invoke x.Ext.init(app) on EgojitOrmApplication#onCreate()"
                        + " and register your EgojitOrmApplication in manifest.");
            }
        }
        return Ext.app;
    }

    public static ViewInjector view() {
        if (Ext.viewInjector == null) {
            ViewInjectorImpl.registerInstance();
        }
        return Ext.viewInjector;
    }


    /**
     * 成功提示
     * @param msg
     */
    public static void showSuccess(String msg){

    }

    /**
     * err提示
     * @param msg
     */
    public static void showError(String msg){

    }

    /**
     * 警告
     * @param msg
     */
    public static void showWarn(String msg){

    }


    public static class Ext {
        private static boolean debug;
        private static EgojitApplication app;
        private static ViewInjector viewInjector;

        private Ext() {
        }



        static {

            // 默认信任所有https域名
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }

        public static void init(EgojitApplication app) {
            if (Ext.app == null) {
                Ext.app = app;
            }
        }

        public static void setDebug(boolean debug) {
            Ext.debug = debug;
        }

//        public static void setTaskController(TaskController taskController) {
//            if (Ext.taskController == null) {
//                Ext.taskController = taskController;
//            }
//        }
//
//        public static void setHttpManager(HttpManager httpManager) {
//            Ext.httpManager = httpManager;
//        }
//
//        public static void setImageManager(ImageManager imageManager) {
//            Ext.imageManager = imageManager;
//        }
//
        public static void setViewInjector(ViewInjector viewInjector) {
            Ext.viewInjector = viewInjector;
        }
    }

}
