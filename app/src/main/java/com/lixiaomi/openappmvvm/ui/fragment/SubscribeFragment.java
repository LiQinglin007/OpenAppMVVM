package com.lixiaomi.openappmvvm.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixiaomi.baselib.ui.dialog.dialoglist.MiDialogList;
import com.lixiaomi.baselib.utils.T;
import com.lixiaomi.mvvmbaselib.base.BaseFragment;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.SubscribeFragmentAdapter;
import com.lixiaomi.openappmvvm.bean.WXArticleAuthorlistBean;
import com.lixiaomi.openappmvvm.bean.WXArticleListBean;
import com.lixiaomi.openappmvvm.databinding.FragmentSubscribeBinding;
import com.lixiaomi.openappmvvm.mv.SubscribeFragmentViewModelImpl;
import com.lixiaomi.openappmvvm.ui.activity.WebViewActivity;
import com.lixiaomi.openappmvvm.utils.FinalData;


import java.util.ArrayList;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SubscribeFragment extends BaseFragment<SubscribeFragmentLifecycle, FragmentSubscribeBinding, SubscribeFragmentViewModelImpl> {

    private SwipeRefreshLayout mRefresh;
    private android.widget.TextView mSubAuthorTv;
    private android.support.v7.widget.RecyclerView mSubRecy;
    private SubscribeFragmentAdapter mSubscribeFragmentAdapter;

    /**
     * 作者列表
     */
    private ArrayList<WXArticleAuthorlistBean.DataBean> mAuthorListData = new ArrayList<>();
    /**
     * 文章列表
     */
    private ArrayList<WXArticleListBean.DataBean.DatasBean> mArticleListData = new ArrayList<>();
    /**
     * 当前选的哪个作者
     */
    private int mChooseIndex = 0;

    /**
     * 现在加载到了多少页
     */
    private int mPage = 0;
    private boolean mRefreshIng = false;
    private boolean mLoadMoreIng = false;

    public static SubscribeFragment getInstance() {
        return SubscribeFragmentImplHolder.mSubscribeFragmentImpl;
    }

    private static final class SubscribeFragmentImplHolder {
        private final static SubscribeFragment mSubscribeFragmentImpl = new SubscribeFragment();
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_subscribe;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mRefresh = rootView.findViewById(R.id.sub_sr);
        mSubAuthorTv = rootView.findViewById(R.id.sub_author_tv);
        mSubRecy = rootView.findViewById(R.id.sub_recy);

        mSubRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSubscribeFragmentAdapter = new SubscribeFragmentAdapter(R.layout.item_wx_article, mArticleListData);
        mSubRecy.setAdapter(mSubscribeFragmentAdapter);
        mSubscribeFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mArticleListData.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mArticleListData.get(position).getTitle())
                );
            }
        });

        mSubAuthorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MiDialogList<String>(getActivity())
                        .builder()
                        .setData(mAuthorListData)
                        .setTitle("选择公众号")
                        .setGravity(MiDialogList.MILIST_DIALOG_BOTTOM)
                        .setReturnType(MiDialogList.MILIST_RETURN_SINGLE)
                        .setCallBack(new MiDialogList.OnDialogListCallback() {
                            @Override
                            public void onListCallback(ArrayList<Integer> dataList) {
                                mChooseIndex = dataList.get(0);
                                mPage = 0;
                                mSubAuthorTv.setText(mAuthorListData.get(mChooseIndex).getName());
                                getData(true);
                            }
                        })
                        .show();
            }
        });

        mSubscribeFragmentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //上拉的时候不能下拉
                if (!mLoadMoreIng || !mRefreshIng) {
                    mLoadMoreIng = true;
                    ++mPage;
                    getData(false);
                    mRefresh.setEnabled(false);
                }
            }
        }, mSubRecy);

        mRefresh.setEnabled(false);
        //设置加载的颜色
        mRefresh.setColorSchemeColors(
                getResources().getColor(R.color.color_51D8BA),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.default_color));
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mRefresh.setSize(SwipeRefreshLayout.LARGE);
        //设置下拉刷新的监听
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!mLoadMoreIng || !mRefreshIng) {
                    mPage = 0;
                    mRefreshIng = true;
                    mSubscribeFragmentAdapter.setEnableLoadMore(false);
                    getData(false);
                }
            }
        });

        mViewModel.getWXAuthorList();
    }

    private void getData(boolean showLoading) {
        mViewModel.getWXArticleList(showLoading, mAuthorListData.get(mChooseIndex).getId() + "", mPage);
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
                T.shortToast(getActivity(), s);
            }
        });

        mViewModel.getmAuthorData().observe(this, new Observer<ArrayList<WXArticleAuthorlistBean.DataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<WXArticleAuthorlistBean.DataBean> dataBeans) {
                mAuthorListData.clear();
                mAuthorListData.addAll(dataBeans);
                if (mAuthorListData.size() > 0) {
                    mSubAuthorTv.setText(mAuthorListData.get(mChooseIndex).getName());
                    getData(true);
                }
            }
        });

        mViewModel.getmArticleData().observe(this, new Observer<WXArticleListBean.DataBean>() {
            @Override
            public void onChanged(@Nullable WXArticleListBean.DataBean dataBean) {
                if (mPage == 0) {
                    mArticleListData.clear();
                }
                mArticleListData.addAll(dataBean.getDatas());
                mSubscribeFragmentAdapter.replaceData(mArticleListData);
                if (dataBean.getCurPage() >= dataBean.getPageCount()) {
                    mSubscribeFragmentAdapter.loadMoreEnd();
                } else {
                    mSubscribeFragmentAdapter.loadMoreComplete();
                }

                mRefresh.setEnabled(true);
                mRefresh.setRefreshing(false);
                mSubscribeFragmentAdapter.setEnableLoadMore(true);
                mRefreshIng = false;
                mLoadMoreIng = false;
            }
        });
    }

    @Override
    protected SubscribeFragmentLifecycle createLifeCycle() {
        return new SubscribeFragmentLifecycle(getActivity());
    }

    @Override
    protected SubscribeFragmentViewModelImpl creatViewModel() {
        return ViewModelProviders.of(SubscribeFragment.getInstance()).get(SubscribeFragmentViewModelImpl.class);
    }


}
