package com.lixiaomi.openappmvvm.mv.activity;

import android.arch.lifecycle.MutableLiveData;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.NetWorkUtils;
import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.bean.TreeArticleListBean;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.model.TreeModelmpl;
import com.lixiaomi.openappmvvm.ui.activity.SystemListActivityLifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemListActivityViewModelImpl extends BaseViewModel<BaseModel, SystemListActivityLifecycle> implements SystemListActivityViewModel {
    private MutableLiveData<TreeArticleListBean.DataBean> mTreeArticleListData = new MutableLiveData<>();
    private TreeArticleListBean.DataBean mTreeArticleBean = new TreeArticleListBean.DataBean();

    public MutableLiveData<TreeArticleListBean.DataBean> getmTreeArticleListData() {
        return mTreeArticleListData;
    }

    @Override
    public void getSystemArticle(final boolean showLoading, int page, String cId) {
        if (showLoading) {
            mShowLoading.setValue(true);
        }
        ((TreeModelmpl) getModelList().get(0)).getTreeList(page, cId, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }
                if (mTreeArticleBean.getDatas() == null) {
                    mTreeArticleBean.setDatas(new ArrayList<TreeArticleListBean.DataBean.DatasBean>());
                    mTreeArticleBean.setPageCount(0);
                    mTreeArticleBean.setCurPage(0);
                }
                if (mTreeArticleBean.getDatas().size() != 0) {
                    mTreeArticleBean.getDatas().clear();
                }

                try {
                    TreeArticleListBean treeBean = MiJsonUtil.getClass(response, TreeArticleListBean.class);
                    if (treeBean.getErrorCode() == 0) {
                        List<TreeArticleListBean.DataBean.DatasBean> data = treeBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            mTreeArticleBean.getDatas().addAll(data);
                            mTreeArticleBean.setPageCount(treeBean.getData().getPageCount());
                            mTreeArticleBean.setCurPage(treeBean.getData().getCurPage());
                            mTreeArticleListData.setValue(mTreeArticleBean);
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
        models.add(new TreeModelmpl());
        return models;
    }

}
