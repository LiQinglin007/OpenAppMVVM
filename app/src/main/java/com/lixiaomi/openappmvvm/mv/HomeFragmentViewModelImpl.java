package com.lixiaomi.openappmvvm.mv;

import android.arch.lifecycle.MutableLiveData;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.NetWorkUtils;
import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ArticleBean;
import com.lixiaomi.openappmvvm.bean.BannerBean;
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.model.ArticleModelImpl;
import com.lixiaomi.openappmvvm.model.PublicModelImpl;
import com.lixiaomi.openappmvvm.ui.fragment.HomeFragmentLifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class HomeFragmentViewModelImpl extends BaseViewModel<BaseModel, HomeFragmentLifecycle> implements HomeFragmentViewModel {

    protected MutableLiveData<ArrayList<BannerBean.DataBean>> mBannerData = new MutableLiveData<>();
    protected MutableLiveData<ArrayList<ProjectBean.DataBean.DatasBean>> mProjectData = new MutableLiveData<>();
    protected MutableLiveData<ArrayList<ArticleBean.DataBean.DatasBean>> mArticleData = new MutableLiveData<>();
    private ArrayList<BannerBean.DataBean> mBannerList = new ArrayList<>();
    private ArrayList<ProjectBean.DataBean.DatasBean> mProjectList = new ArrayList<>();
    private ArrayList<ArticleBean.DataBean.DatasBean> mArticleList = new ArrayList<>();

    public MutableLiveData<ArrayList<BannerBean.DataBean>> getmBannerData() {
        return mBannerData;
    }

    public MutableLiveData<ArrayList<ProjectBean.DataBean.DatasBean>> getmProjectData() {
        return mProjectData;
    }

    public MutableLiveData<ArrayList<ArticleBean.DataBean.DatasBean>> getmArticleData() {
        return mArticleData;
    }

    @Override
    protected ArrayList<BaseModel> createModelList() {
        ArrayList<BaseModel> modelList = new ArrayList<>();
        modelList.add(new PublicModelImpl());
        modelList.add(new ArticleModelImpl());
        return modelList;
    }

    @Override
    public void getBannerData() {
        mShowLoading.setValue(true);
        ((PublicModelImpl) getModelList().get(0)).getBannerList(new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                mShowLoading.setValue(false);
                mBannerList.clear();
                try {
                    BannerBean roomListBean = MiJsonUtil.getClass(response, BannerBean.class);
                    if (roomListBean.getErrorCode() == 0) {
                        List<BannerBean.DataBean> data = roomListBean.getData();
                        if (data != null && data.size() != 0) {
                            mBannerList.addAll(data);
                            mBannerData.setValue(mBannerList);
                        }
                    }
                } catch (Exception e) {
                    mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_AnalysisError));
                }
            }

            @Override
            public void error(String message) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(message);
            }

            @Override
            public void failure(Throwable e) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(
                        NetWorkUtils.isNetworkConnected(AppConfigInIt.getApplicationContext()) ? R.string.http_onFailure : R.string.http_NoNetWorkError));
            }
        });
    }

    @Override
    public void getArticleData() {
        mShowLoading.setValue(true);
        ((ArticleModelImpl) getModelList().get(1)).getArtcleList(0, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                mShowLoading.setValue(false);
                mArticleList.clear();
                try {
                    ArticleBean articleBean = MiJsonUtil.getClass(response, ArticleBean.class);
                    if (articleBean.getErrorCode() == 0) {
                        List<ArticleBean.DataBean.DatasBean> data = articleBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            if (data.size() > 5) {
                                mArticleList.add(data.get(0));
                                mArticleList.add(data.get(1));
                                mArticleList.add(data.get(2));
                                mArticleList.add(data.get(3));
                                mArticleList.add(data.get(4));
                            } else {
                                mArticleList.addAll(data);
                            }
                            mArticleData.setValue(mArticleList);
                        }
                    }
                } catch (Exception e) {
                    mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_AnalysisError));
                }
            }

            @Override
            public void error(String message) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(message);
            }

            @Override
            public void failure(Throwable e) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(
                        NetWorkUtils.isNetworkConnected(AppConfigInIt.getApplicationContext()) ? R.string.http_onFailure : R.string.http_NoNetWorkError));
            }
        });
    }

    @Override
    public void getProjetData() {
        mShowLoading.setValue(true);
        ((ArticleModelImpl) getModelList().get(1)).getArtcleProjectList(0, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                mShowLoading.setValue(false);
                mProjectList.clear();
                try {
                    ProjectBean projectBean = MiJsonUtil.getClass(response, ProjectBean.class);
                    if (projectBean.getErrorCode() == 0) {
                        List<ProjectBean.DataBean.DatasBean> data = projectBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            if (data.size() > 5) {
                                mProjectList.add(data.get(0));
                                mProjectList.add(data.get(1));
                                mProjectList.add(data.get(2));
                                mProjectList.add(data.get(3));
                                mProjectList.add(data.get(4));
                            } else {
                                mProjectList.addAll(data);
                            }
                            mProjectData.setValue(mProjectList);
                        }
                    }
                } catch (Exception e) {
                    mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_AnalysisError));
                }
            }

            @Override
            public void error(String message) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(message);
            }

            @Override
            public void failure(Throwable e) {
                mShowLoading.setValue(false);
                mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(
                        NetWorkUtils.isNetworkConnected(AppConfigInIt.getApplicationContext()) ? R.string.http_onFailure : R.string.http_NoNetWorkError));
            }
        });
    }
}
