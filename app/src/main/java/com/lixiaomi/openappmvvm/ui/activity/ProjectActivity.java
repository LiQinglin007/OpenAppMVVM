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
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.ProjectAdapter;
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.databinding.ActivityProjectListBinding;
import com.lixiaomi.openappmvvm.mv.activity.ProjectActivityViewModelImpl;
import com.lixiaomi.openappmvvm.utils.FinalData;


import java.util.ArrayList;

/**
 * @describe：项目列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/1<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ProjectActivity extends BaseActivity<ProjectActivityLifeCycle, ActivityProjectListBinding, ProjectActivityViewModelImpl> {

    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;

    private ProjectAdapter mAdapter;
    private ArrayList<ProjectBean.DataBean.DatasBean> mDataList = new ArrayList();
    private int mPage = 0;
    private boolean mLoadMoreIng = false;
    private boolean mRefreshIng = false;
    private SwipeRefreshLayout mProjectRefresh;
    private android.support.v7.widget.RecyclerView mProjectRecy;


    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_project_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTopLeftLy = findViewById(R.id.top_back_ly);
        mTopRightLy = findViewById(R.id.top_right_ly);
        mTopTitleTv = findViewById(R.id.top_title_tv);
        mTopTitleTv.setText("最新项目");
        mTopLeftLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopRightLy.setVisibility(View.INVISIBLE);

        mProjectRefresh = findViewById(R.id.project_refresh);
        mProjectRecy = findViewById(R.id.project_recy);
        mProjectRecy.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ProjectAdapter(R.layout.item_project, mDataList);
        mAdapter.setNewData(mDataList);
        mProjectRecy.setAdapter(mAdapter);

        mProjectRefresh.setEnabled(true);
        mProjectRefresh.setColorSchemeColors(
                getResources().getColor(R.color.color_51D8BA),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.default_color));
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mProjectRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mProjectRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mProjectRefresh.setSize(SwipeRefreshLayout.LARGE);
        mProjectRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
                    mProjectRefresh.setEnabled(false);
                    getData(false);
                }
            }
        }, mProjectRecy);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(ProjectActivity.this, WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mDataList.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mDataList.get(position).getTitle())
                );
            }
        });
        getData(true);
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
                T.shortToast(ProjectActivity.this, s);
            }
        });

        mViewModel.getmProjectListData().observe(this, new Observer<ProjectBean.DataBean>() {
            @Override
            public void onChanged(@Nullable ProjectBean.DataBean dataBean) {
                if (mPage == 0) {
                    mDataList.clear();
                }
                mDataList.addAll(dataBean.getDatas());
                mAdapter.replaceData(mDataList);
                mProjectRefresh.setEnabled(true);
                mProjectRefresh.setRefreshing(false);
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


    private void getData(boolean showLoading) {
        mViewModel.getProjectData(showLoading, mPage);
    }

    @Override
    protected ProjectActivityLifeCycle createLifeCycle() {
        return new ProjectActivityLifeCycle(this);
    }


    @Override
    protected ProjectActivityViewModelImpl creatViewModel() {
        return ViewModelProviders.of(this).get(ProjectActivityViewModelImpl.class);
    }


    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }

}
