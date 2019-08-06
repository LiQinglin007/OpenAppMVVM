package com.lixiaomi.openappmvvm.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.lixiaomi.mvvmbaselib.base.BaseFragment;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ArticleBean;
import com.lixiaomi.openappmvvm.bean.BannerBean;
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.databinding.FragmentHomeBinding;
import com.lixiaomi.openappmvvm.mv.HomeFragmentViewModel;


import java.util.ArrayList;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class HomeFragment extends BaseFragment<HomeFragmentLifecycle, FragmentHomeBinding, HomeFragmentViewModel> {

    private ConvenientBanner mHomeBanner;
    private RecyclerView mHomeRecyArticle;
    private RecyclerView mHomeRecyProject;


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


//        mArticleAdapter = new ArticleAdapter(R.layout.item_article);
//        mHomeRecyArticle.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mHomeRecyArticle.setAdapter(mArticleAdapter);
//        View articleHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.head_home_article, mHomeRecyArticle, false);
//        articleHeadView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ArticleActivity.class));
//            }
//        });
//        mArticleAdapter.addHeaderView(articleHeadView);
//
//        mProjectAdapter = new ProjectAdapter(R.layout.item_project);
//        mHomeRecyProject.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mHomeRecyProject.setAdapter(mProjectAdapter);
//        View projectHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.head_home_project, mHomeRecyProject, false);
//        projectHeadView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ProjectActivity.class));
//            }
//        });
//        mProjectAdapter.addHeaderView(projectHeadView);
//
//        //加载图片
//        mPersenter.getBannerData();
//        mPersenter.getHomeArticle();
//        mPersenter.getHomeArticleProject();
//
//        mArticleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(getActivity(), WebViewActivity.class)
//                        .putExtra(FinalData.WEB_VIEW_URL, mArticleDataList.get(position).getLink())
//                        .putExtra(FinalData.WEB_VIEW_TITLE, mArticleDataList.get(position).getTitle())
//                );
//            }
//        });
//
//        mProjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(getActivity(), WebViewActivity.class)
//                        .putExtra(FinalData.WEB_VIEW_URL, mProjectDataList.get(position).getLink())
//                        .putExtra(FinalData.WEB_VIEW_TITLE, mProjectDataList.get(position).getTitle())
//                );
//            }
//        });
    }

    @Override
    protected void startListenerData() {

    }

    @Override
    protected HomeFragmentLifecycle createLifeCycle() {
        return new HomeFragmentLifecycle(getActivity());
    }

    @Override
    protected HomeFragmentViewModel creatViewModel() {
        return new HomeFragmentViewModel();
    }


//    @Override
//    public void setBannerData(ArrayList<BannerBean.DataBean> bannerList, int code, String msg) {
//        mDataList.clear();
//        if (code == HttpData.LOCAL_SUCCESS) {
//            mDataList.addAll(bannerList);
//            //给Banner设置图片
//            mHomeBanner.setPages(
//                    new CBViewHolderCreator() {
//                        @Override
//                        public Holder createHolder(View itemView) {
//                            return new BannerHolderView(itemView);
//                        }
//
//                        @Override
//                        public int getLayoutId() {
//                            return R.layout.item_localimage;
//                        }
//                    }, mDataList)
//                    .setOnItemClickListener(new OnItemClickListener() {
//                        @Override
//                        public void onItemClick(int position) {
//                            startActivity(new Intent(getActivity(), WebViewActivity.class)
//                                    .putExtra(FinalData.WEB_VIEW_URL, mDataList.get(position).getUrl())
//                                    .putExtra(FinalData.WEB_VIEW_TITLE, mDataList.get(position).getTitle())
//                            );
//                        }
//                    })
//                    .setPageIndicator(new int[]{R.drawable.dot_focus, R.drawable.dot_normal})
//                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
//        } else {
//            T.shortToast(getActivity(), msg);
//        }
//    }
//
//    @Override
//    public void setArticleProject(ArrayList<ProjectBean.DataBean.DatasBean> projectList, int code, String msg) {
//        mProjectDataList.clear();
//        if (code == HttpData.LOCAL_SUCCESS) {
//            mProjectDataList.addAll(projectList);
//            LogUtils.loge("mProjectDataList" + MiJsonUtil.getJson(mProjectDataList));
//        } else {
//            T.shortToast(getActivity(), msg);
//        }
//        mProjectAdapter.setNewData(mProjectDataList);
//    }
//
//    @Override
//    public void setArticle(ArrayList<ArticleBean.DataBean.DatasBean> articleList, int code, String msg) {
//        mArticleDataList.clear();
//        if (code == HttpData.LOCAL_SUCCESS) {
//            mArticleDataList.addAll(articleList);
//            LogUtils.loge("mArticleDataList" + MiJsonUtil.getJson(mArticleDataList));
//        } else {
//            T.shortToast(getActivity(), msg);
//        }
//        mArticleAdapter.setNewData(mArticleDataList);
//    }

}
