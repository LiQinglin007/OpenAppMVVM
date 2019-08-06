package com.lixiaomi.openappmvvm.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

import com.lixiaomi.baselib.utils.LogUtils;
import com.lixiaomi.mvvmbaselib.base.BaseActivity;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.utils.FinalData;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * @describe：banner点击过来这里，文章详情点击过来这里，来这里展示所有的<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class WebViewActivity extends BaseActivity {
    private String mWebViewUrl;
    private String mTitle;
    private com.lixiaomi.openappmvvm.view.ProgressWebview mWebView;


    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;


    @Override
    protected int setLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected BaseViewModel creatViewModel() {
        return null;
    }

    @Override
    protected void initData() {
        mWebViewUrl = getIntent().getStringExtra(FinalData.WEB_VIEW_URL);
        mTitle = getIntent().getStringExtra(FinalData.WEB_VIEW_TITLE);
        LogUtils.loge("mWebViewUrl:" + mWebViewUrl);
        LogUtils.loge("mTitle:" + mTitle);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTopLeftLy = findViewById(R.id.top_back_ly);
        mTopRightLy = findViewById(R.id.top_right_ly);
        mTopTitleTv = findViewById(R.id.top_title_tv);
        mTopTitleTv.setText(mTitle);
        mTopLeftLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    finish();
                }
            }
        });
        mTopRightLy.setVisibility(View.INVISIBLE);

        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });
        //设置WebView属性,运行执行js脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //调用loadUrl方法为WebView加入链接
        mWebView.loadUrl(mWebViewUrl);
    }

    @Override
    protected BaseLifeCycle createLifeCycle() {
        return null;
    }

    @Override
    protected void startListenerData() {

    }


    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            WebViewActivity.this.finish();
        }
    }
}
