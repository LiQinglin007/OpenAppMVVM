package com.lixiaomi.openappmvvm.model;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.net.okhttp.MiOkHttpCallBack;
import com.lixiaomi.baselib.net.okhttp.MiSendRequestOkHttp;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.http.MyUrl;


/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class PublicModelImpl implements PublicModel {

    @Override
    public void getBannerList(final MyPresenterCallBack myPresenterCallBack) {

        MiSendRequestOkHttp.sendGet(null, null, MyUrl.getBannerGet(), 60 * 10, new MiOkHttpCallBack() {
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
