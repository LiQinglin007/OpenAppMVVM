package com.lixiaomi.openappmvvm.mv;

import android.arch.lifecycle.MutableLiveData;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.NetWorkUtils;
import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.WXArticleAuthorlistBean;
import com.lixiaomi.openappmvvm.bean.WXArticleListBean;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.model.WXArticleModelImpl;
import com.lixiaomi.openappmvvm.ui.fragment.SubscribeFragmentLifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：公众号模块<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SubscribeFragmentViewModelImpl extends BaseViewModel<BaseModel, SubscribeFragmentLifecycle> implements SubscribeFragmentViewModel {
    private MutableLiveData<ArrayList<WXArticleAuthorlistBean.DataBean>> mAuthorData = new MutableLiveData<>();
    private MutableLiveData<WXArticleListBean.DataBean> mArticleData = new MutableLiveData<>();
    private ArrayList<WXArticleAuthorlistBean.DataBean> mAuthorList = new ArrayList<>();
    private WXArticleListBean.DataBean mArticleBean = new WXArticleListBean.DataBean();

    public MutableLiveData<ArrayList<WXArticleAuthorlistBean.DataBean>> getmAuthorData() {
        return mAuthorData;
    }

    public MutableLiveData<WXArticleListBean.DataBean> getmArticleData() {
        return mArticleData;
    }

    @Override
    public void getWXAuthorList() {
        mShowLoading.setValue(true);
        ((WXArticleModelImpl) getModelList().get(0)).getWXArticleAuthorList(new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                mShowLoading.setValue(false);
                mAuthorList.clear();
                try {
                    WXArticleAuthorlistBean articleAuthorlistBean = MiJsonUtil.getClass(response, WXArticleAuthorlistBean.class);
                    if (articleAuthorlistBean.getErrorCode() == 0) {
                        List<WXArticleAuthorlistBean.DataBean> data = articleAuthorlistBean.getData();
                        if (data != null && data.size() != 0) {
                            mAuthorList.addAll(data);
                            mAuthorData.setValue(mAuthorList);
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
    public void getWXArticleList(final boolean showLoading, String authorId, int page) {
        if (showLoading) {
            mShowLoading.setValue(true);
        }
        ((WXArticleModelImpl) getModelList().get(0)).getWXArticleListByAuthorId(authorId, page, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }
                if (mArticleBean.getDatas() == null) {
                    mArticleBean.setDatas(new ArrayList<WXArticleListBean.DataBean.DatasBean>());
                    mArticleBean.setPageCount(0);
                    mArticleBean.setCurPage(0);
                }
                if (mArticleBean.getDatas().size() != 0) {
                    mArticleBean.getDatas().clear();
                }
                try {
                    WXArticleListBean articleListBean = MiJsonUtil.getClass(response, WXArticleListBean.class);
                    if (articleListBean.getErrorCode() == 0) {
                        List<WXArticleListBean.DataBean.DatasBean> data = articleListBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            mArticleBean.getDatas().addAll(data);
                            mArticleBean.setPageCount(articleListBean.getData().getPageCount());
                            mArticleBean.setCurPage(articleListBean.getData().getCurPage());
                            mArticleData.setValue(mArticleBean);
                        }
                    }
                } catch (Exception e) {
                    mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(R.string.http_AnalysisError));
                }
            }

            @Override
            public void error(String message) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }
                mToastMessage.setValue(message);
            }

            @Override
            public void failure(Throwable e) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }
                mToastMessage.setValue(AppConfigInIt.getApplicationContext().getResources().getString(
                        NetWorkUtils.isNetworkConnected(AppConfigInIt.getApplicationContext()) ? R.string.http_onFailure : R.string.http_NoNetWorkError));
            }
        });
    }

    @Override
    protected ArrayList<BaseModel> createModelList() {
        ArrayList<BaseModel> models = new ArrayList<>();
        models.add(new WXArticleModelImpl());
        return models;
    }
}
