package com.lixiaomi.openappmvvm.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixiaomi.baselib.utils.T;
import com.lixiaomi.mvvmbaselib.base.BaseActivity;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.ArticleAdapter;
import com.lixiaomi.openappmvvm.bean.ArticleBean;
import com.lixiaomi.openappmvvm.databinding.ActivityArticleListBinding;
import com.lixiaomi.openappmvvm.databinding.ActivityArticleListBindingImpl;
import com.lixiaomi.openappmvvm.databinding.FragmentHomeBinding;
import com.lixiaomi.openappmvvm.mv.HomeFragmentViewModelImpl;
import com.lixiaomi.openappmvvm.mv.activity.ArticleActivityViewModelImpl;
import com.lixiaomi.openappmvvm.utils.FinalData;


import java.util.ArrayList;

/**
 * @describe：文章列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/1<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ArticleActivity extends BaseActivity<ArticleActivityLifeCycle, ActivityArticleListBinding, ArticleActivityViewModelImpl> {
    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;

    private SwipeRefreshLayout mArticleRefresh;
    private android.support.v7.widget.RecyclerView mArticleRecy;

    private ArticleAdapter mAdapter;
    private ArrayList<ArticleBean.DataBean.DatasBean> mDataList = new ArrayList();
    private int mPage = 0;
    private boolean mLoadMoreIng = false;
    private boolean mRefreshIng = false;


    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_article_list;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        mTopLeftLy = findViewById(R.id.top_back_ly);
        mTopRightLy = findViewById(R.id.top_right_ly);
        mTopTitleTv = findViewById(R.id.top_title_tv);
        mTopTitleTv.setText("最新文章");
        mTopLeftLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopRightLy.setVisibility(View.INVISIBLE);
        mArticleRefresh = findViewById(R.id.article_refresh);
        mArticleRecy = findViewById(R.id.article_recy);

        mArticleRecy.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ArticleAdapter(R.layout.item_article, mDataList);
        mAdapter.setNewData(mDataList);
        mArticleRecy.setAdapter(mAdapter);

        mArticleRefresh.setEnabled(true);
        mArticleRefresh.setColorSchemeColors(
                getResources().getColor(R.color.color_51D8BA),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.default_color));
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mArticleRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mArticleRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mArticleRefresh.setSize(SwipeRefreshLayout.LARGE);
        mArticleRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!mLoadMoreIng && !mRefreshIng) {
                    mRefreshIng = true;
                    mPage = 0;
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
                    mArticleRefresh.setEnabled(false);
                    getData(false);
                }
            }
        }, mArticleRecy);


        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(ArticleActivity.this, WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mDataList.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mDataList.get(position).getTitle())
                );
            }
        });
        getData(true);
    }

    private void getData(boolean showLoading) {
        mViewModel.getArticleData(showLoading, mPage);
    }

    @Override
    protected void startListenerData() {
        mViewModel.getmShowLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                setLoading(aBoolean);
            }
        });

        mViewModel.getmToastMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                T.shortToast(ArticleActivity.this, s);
            }
        });

        mViewModel.getmArticleListData().observe(this, new Observer<ArticleBean.DataBean>() {
            @Override
            public void onChanged(@Nullable ArticleBean.DataBean dataBean) {
                if (mPage == 0) {
                    mDataList.clear();
                }
                mDataList.addAll(dataBean.getDatas());
                mAdapter.replaceData(mDataList);
                mArticleRefresh.setEnabled(true);
                mArticleRefresh.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);
                mLoadMoreIng = false;
                mRefreshIng = false;
                if (dataBean.getCurPage() >= dataBean.getPageCount()) {
                    mAdapter.loadMoreEnd();
                } else {
                    mAdapter.loadMoreComplete();
                }
            }
        });
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }

    @Override
    protected ArticleActivityLifeCycle createLifeCycle() {
        return new ArticleActivityLifeCycle(this);
    }

    @Override
    protected ArticleActivityViewModelImpl creatViewModel() {
        return ViewModelProviders.of(this).get(ArticleActivityViewModelImpl.class);
    }
}
