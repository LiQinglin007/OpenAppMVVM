package com.lixiaomi.openappmvvm.application;

import android.app.Activity;
import android.app.Application;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2018/3/31
 * 内容：
 * 最后修改：
 */

public class MyApplication extends Application {
    private final String SharedPreferences = "OpenAppMVVM";

    @Override
    public void onCreate() {
        super.onCreate();

        AppConfigInIt.init(this)
                //设置调试模式，默认false
                .withDebug(true)
                //配置SharedPreferences
                .withSharedPreferences(getSharedPreferences(SharedPreferences, Activity.MODE_PRIVATE))
                //默认文件根地址
                .withBaseFile("com.lixiaomi.openappmvvm")
                //baseUrl
                .withBaseUrl("https://www.wanandroid.com/")
                .withHttpCertificateFlag(true, null)
                //连接失败后是否重连
                .withHttpRetryConnection(true)
                .configure();
        QbSdk.initX5Environment(this, null);
        Bugly.init(getApplicationContext(), "0ff1d31517", true);
//        CrashReport.initCrashReport(getApplicationContext(), "0ff1d31517", true);
    }
}
