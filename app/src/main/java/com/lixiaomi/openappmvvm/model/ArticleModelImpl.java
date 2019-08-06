package com.lixiaomi.openappmvvm.model;


import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.net.okhttp.MiOkHttpCallBack;
import com.lixiaomi.baselib.net.okhttp.MiSendRequestOkHttp;
import com.lixiaomi.baselib.utils.LogUtils;
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
public class ArticleModelImpl implements ArticleModel {

    @Override
    public void getArtcleList(int page, final MyPresenterCallBack myPresenterCallBack) {
        MiSendRequestOkHttp.sendGet(null, null, MyUrl.getArticleGet() + page + "/json", 120, new MiOkHttpCallBack() {
            @Override
            public void onSuccess(int code, String response) {
                LogUtils.loge("code:" + code + "  response:" + response);
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
    public void getArtcleProjectList(int page, final MyPresenterCallBack myPresenterCallBack) {
        MiSendRequestOkHttp.sendGet(null, null, MyUrl.getArticleProjectGet() + page + "/json", 120, new MiOkHttpCallBack() {
            @Override
            public void onSuccess(int code, String response) {
                LogUtils.loge("code:" + code + "  response:" + response);
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
