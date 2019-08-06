package com.lixiaomi.openappmvvm.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixiaomi.baselib.utils.LogUtils;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.T;
import com.lixiaomi.mvvmbaselib.base.BaseFragment;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.ArticleAdapter;
import com.lixiaomi.openappmvvm.adapter.BannerHolderView;
import com.lixiaomi.openappmvvm.adapter.ProjectAdapter;
import com.lixiaomi.openappmvvm.bean.ArticleBean;
import com.lixiaomi.openappmvvm.bean.BannerBean;
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.databinding.FragmentHomeBinding;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.mv.HomeFragmentViewModelImpl;
import com.lixiaomi.openappmvvm.ui.activity.ArticleActivity;
import com.lixiaomi.openappmvvm.ui.activity.ProjectActivity;
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
public class HomeFragment extends BaseFragment<HomeFragmentLifecycle, FragmentHomeBinding, HomeFragmentViewModelImpl> {

    private ConvenientBanner mHomeBanner;
    private RecyclerView mHomeRecyArticle;
    private RecyclerView mHomeRecyProject;
    private ArticleAdapter mArticleAdapter;
    private ProjectAdapter mProjectAdapter;

    public static HomeFragment getInstance() {
        return HomeFragmentImplHolder.mHomeFragmentImpl;
    }

    private static final class HomeFragmentImplHolder {
        private final static HomeFragment mHomeFragmentImpl = new HomeFragment();
    }

    ArrayList<BannerBean.DataBean> mDataList = new ArrayList<>();
    ArrayList<ArticleBean.DataBean.DatasBean> mArticleDataList = new ArrayList<>();
    ArrayList<ProjectBean.DataBean.DatasBean> mProjectDataList = new ArrayList<>();


    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mHomeBanner = rootView.findViewById(R.id.home_banner);
        mHomeRecyArticle = rootView.findViewById(R.id.home_recy_article);
        mHomeRecyProject = rootView.findViewById(R.id.home_recy_project);

        mArticleAdapter = new ArticleAdapter(R.layout.item_article, mArticleDataList);
        mHomeRecyArticle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeRecyArticle.setAdapter(mArticleAdapter);
        View articleHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.head_home_article, mHomeRecyArticle, false);
        articleHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ArticleActivity.class));
            }
        });
        mArticleAdapter.addHeaderView(articleHeadView);

        mProjectAdapter = new ProjectAdapter(R.layout.item_project, mProjectDataList);
        mHomeRecyProject.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeRecyProject.setAdapter(mProjectAdapter);
        View projectHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.head_home_project, mHomeRecyProject, false);
        projectHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProjectActivity.class));
            }
        });
        mProjectAdapter.addHeaderView(projectHeadView);

        mArticleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mArticleDataList.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mArticleDataList.get(position).getTitle())
                );
            }
        });

        mProjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, mProjectDataList.get(position).getLink())
                        .putExtra(FinalData.WEB_VIEW_TITLE, mProjectDataList.get(position).getTitle())
                );
            }
        });

        mViewModel.getBannerData();
        mViewModel.getArticleData();
        mViewModel.getProjetData();

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

        mViewModel.getmBannerData().observe(this, new Observer<ArrayList<BannerBean.DataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<BannerBean.DataBean> dataBeans) {
                mDataList.clear();
                mDataList.addAll(dataBeans);
                //给Banner设置图片
                mHomeBanner.setPages(
                        new CBViewHolderCreator() {
                            @Override
                            public Holder createHolder(View itemView) {
                                return new BannerHolderView(itemView);
                            }

                            @Override
                            public int getLayoutId() {
                                return R.layout.item_localimage;
                            }
                        }, mDataList)
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                startActivity(new Intent(getActivity(), WebViewActivity.class)
                                        .putExtra(FinalData.WEB_VIEW_URL, mDataList.get(position).getUrl())
                                        .putExtra(FinalData.WEB_VIEW_TITLE, mDataList.get(position).getTitle())
                                );
                            }
                        })
                        .setPageIndicator(new int[]{R.drawable.dot_focus, R.drawable.dot_normal})
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
            }
        });


        mViewModel.getmArticleData().observe(this, new Observer<ArrayList<ArticleBean.DataBean.DatasBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<ArticleBean.DataBean.DatasBean> datasBeans) {
                mArticleDataList.clear();
                mArticleDataList.addAll(datasBeans);
                LogUtils.loge("mArticleDataList" + MiJsonUtil.getJson(mArticleDataList));
                mArticleAdapter.replaceData(mArticleDataList);
            }
        });


        mViewModel.getmProjectData().observe(this, new Observer<ArrayList<ProjectBean.DataBean.DatasBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<ProjectBean.DataBean.DatasBean> datasBeans) {
                mProjectDataList.clear();
                mProjectDataList.addAll(datasBeans);
                LogUtils.loge("mProjectDataList" + MiJsonUtil.getJson(mProjectDataList));
                mProjectAdapter.replaceData(mProjectDataList);
            }
        });
    }

    @Override
    protected HomeFragmentLifecycle createLifeCycle() {
        return new HomeFragmentLifecycle(getActivity());
    }

    @Override
    protected HomeFragmentViewModelImpl creatViewModel() {
        return ViewModelProviders.of(HomeFragment.getInstance()).get(HomeFragmentViewModelImpl.class);
    }
}
