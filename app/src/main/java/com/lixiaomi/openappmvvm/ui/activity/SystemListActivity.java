package com.lixiaomi.openappmvvm.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixiaomi.mvvmbaselib.base.BaseActivity;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.SystemActivityAdapter;
import com.lixiaomi.openappmvvm.bean.TreeArticleListBean;
import com.lixiaomi.openappmvvm.utils.FinalData;


import java.util.ArrayList;

/**
 * @describe：体系文章列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/1<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemListActivity extends BaseActivity {

    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;

    private int mCId;
    private String mTitle;
    private android.support.v7.widget.RecyclerView mSystemRecy;
    private SwipeRefreshLayout mRefreshLy;
    private SystemActivityAdapter mAdapter;
    private ArrayList<TreeArticleListBean.DataBean.DatasBean> mDataList = new ArrayList();
    private int mPage = 1;
    private boolean mLoadMoreIng = false;
    private boolean mRefreshIng = false;

    @Override
    protected int setLayout() {
        return R.layout.activity_system_list;
    }

    @Override
    protected BaseViewModel creatViewModel() {
        return null;
    }

    @Override
    protected void initData() {
        mCId = getIntent().getIntExtra(FinalData.SYSTEM_TYPE_ID, -1);
        mTitle = getIntent().getStringExtra(FinalData.SYSTEM_TYPE_TITLE);
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
                finish();
            }
        });
        mTopRightLy.setVisibility(View.INVISIBLE);


        mRefreshLy = findViewById(R.id.system_refresh);
        mSystemRecy = findViewById(R.id.system_recy);
        mSystemRecy.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SystemActivityAdapter(R.layout.item_sys_article, mDataList);
        mSystemRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(SystemListActivity.this, WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mDataList.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mDataList.get(position).getTitle())
                );
            }
        });


        mRefreshLy.setEnabled(true);
        mRefreshLy.setColorSchemeColors(
                getResources().getColor(R.color.color_51D8BA),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.default_color));
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mRefreshLy.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mRefreshLy.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mRefreshLy.setSize(SwipeRefreshLayout.LARGE);
        mRefreshLy.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!mLoadMoreIng && !mRefreshIng) {
                    mRefreshIng = true;
                    mPage = 1;
                    //下拉刷新的时候不让上拉加载
                    mAdapter.setEnableLoadMore(false);
                    getData(false);
                }
            }
        });

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (!mLoadMoreIng && !mRefreshIng) {
                    mLoadMoreIng = true;
                    ++mPage;
                    //上拉加载的时候不让下拉刷新
                    mRefreshLy.setEnabled(false);
                    getData(false);
                }
            }
        }, mSystemRecy);

        getData(true);

    }

    @Override
    protected BaseLifeCycle createLifeCycle() {
        return null;
    }

    @Override
    protected void startListenerData() {

    }

    private void getData(boolean showLoading) {
        if (mCId != -1) {
//            mPersenter.getSystemArticle(showLoading, mPage, mCId + "");
        }
    }

//    @Override
//    public void setSystemArticleList(int page, ArrayList<TreeArticleListBean.DataBean.DatasBean> list, int code, String msg) {
//        if (mPage == 1) {
//            mDataList.clear();
//        }
//        mDataList.addAll(list);
//        mAdapter.replaceData(mDataList);
//        mRefreshLy.setEnabled(true);
//        mRefreshLy.setRefreshing(false);
//        mAdapter.setEnableLoadMore(true);
//        mLoadMoreIng = false;
//        mRefreshIng = false;
//        if (mPage >= page) {
//            mAdapter.loadMoreEnd();
//        } else {
//            mAdapter.loadMoreComplete();
//        }
//    }

    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }

}
