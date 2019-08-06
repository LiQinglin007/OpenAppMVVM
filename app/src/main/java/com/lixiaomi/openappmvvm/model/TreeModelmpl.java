package com.lixiaomi.openappmvvm.model;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.net.okhttp.MiOkHttpCallBack;
import com.lixiaomi.baselib.net.okhttp.MiSendRequestOkHttp;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.http.MyUrl;


import java.util.WeakHashMap;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/1<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class TreeModelmpl implements TreeModel {

    @Override
    public void getTreeTypeList(final MyPresenterCallBack myPresenterCallBack) {
        MiSendRequestOkHttp.sendGet(null, null, MyUrl.getTreeGet(), 120, new MiOkHttpCallBack() {
            @Override
            public void onSuccess(int code, String response) {
                if (code != HttpData.HTTP_SUCCESS_CODE) {
                    myPresenterCallBack.error(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_ServiceError));
                    return;
                }
                if (response.contains(HttpData.SERVER_ERROR_STR)) {
                    myPresenterCallBack.error(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_ServiceError));
                    return;
                }
                myPresenterCallBack.success(code, response);
            }

            @Override
            public void onFailure(Throwable e) {
                myPresenterCallBack.failure(e);
            }
        });
    }

    @Override
    public void getTreeList(int page, String cId, final MyPresenterCallBack myPresenterCallBack) {
        WeakHashMap<String, Object> para = new WeakHashMap<>(1);
        para.put("cid", cId);
        MiSendRequestOkHttp.sendGet(null, para, MyUrl.getTreeListGet() + page + "/json", 120, new MiOkHttpCallBack() {
            @Override
            public void onSuccess(int code, String response) {
                if (code != HttpData.HTTP_SUCCESS_CODE) {
                    myPresenterCallBack.error(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_ServiceError));
                    return;
                }
                if (response.contains(HttpData.SERVER_ERROR_STR)) {
                    myPresenterCallBack.error(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_ServiceError));
                    return;
                }
                myPresenterCallBack.success(code, response);
            }

            @Override
            public void onFailure(Throwable e) {
                myPresenterCallBack.failure(e);
            }
        });
    }
}
