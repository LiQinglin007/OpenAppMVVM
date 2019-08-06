package com.lixiaomi.openappmvvm.mv.activity;

import android.arch.lifecycle.MutableLiveData;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.NetWorkUtils;
import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ArticleBean;
import com.lixiaomi.openappmvvm.bean.WXArticleListBean;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.model.ArticleModelImpl;
import com.lixiaomi.openappmvvm.ui.activity.ArticleActivityLifeCycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ArticleActivityViewModelImpl extends BaseViewModel<BaseModel, ArticleActivityLifeCycle> implements ArticleActivityViewModel {
    private MutableLiveData<ArticleBean.DataBean> mArticleListData = new MutableLiveData<>();
    private ArticleBean.DataBean mArticleBean = new ArticleBean.DataBean();

    public MutableLiveData<ArticleBean.DataBean> getmArticleListData() {
        return mArticleListData;
    }

    @Override
    public void getArticleData(final boolean showLoading, int page) {
        if (showLoading) {
            mShowLoading.setValue(true);
        }
        ((ArticleModelImpl) getModelList().get(0)).getArtcleList(page, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }

                if (mArticleBean.getDatas() == null) {
                    mArticleBean.setDatas(new ArrayList<ArticleBean.DataBean.DatasBean>());
                    mArticleBean.setPageCount(0);
                }
                if (mArticleBean.getDatas().size() != 0) {
                    mArticleBean.getDatas().clear();
                }
                try {
                    ArticleBean articleBean = MiJsonUtil.getClass(response, ArticleBean.class);
                    if (articleBean.getErrorCode() == 0) {
                        List<ArticleBean.DataBean.DatasBean> data = articleBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            mArticleBean.getDatas().addAll(data);
                            mArticleBean.setPageCount(articleBean.getData().getPageCount());
                            mArticleListData.setValue(mArticleBean);
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
    protected ArrayList createModelList() {
        ArrayList<BaseModel> models = new ArrayList<>();
        models.add(new ArticleModelImpl());
        return models;
    }
}
