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
import com.lixiaomi.openappmvvm.bean.ProjectBean;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.model.ArticleModelImpl;
import com.lixiaomi.openappmvvm.ui.activity.ProjectActivityLifeCycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ProjectActivityViewModelImpl extends BaseViewModel<BaseModel, ProjectActivityLifeCycle> implements ProjectActivityViewModel {
    private MutableLiveData<ProjectBean.DataBean> mProjectListData = new MutableLiveData<>();
    private ProjectBean.DataBean mProjectBean = new ProjectBean.DataBean();


    public MutableLiveData<ProjectBean.DataBean> getmProjectListData() {
        return mProjectListData;
    }

    @Override
    public void getProjectData(final boolean showLoading, int page) {
        if (showLoading) {
            mShowLoading.setValue(true);
        }
        ((ArticleModelImpl) getModelList().get(0)).getArtcleProjectList(page, new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                if (showLoading) {
                    mShowLoading.setValue(false);
                }

                if (mProjectBean.getDatas() == null) {
                    mProjectBean.setDatas(new ArrayList<ProjectBean.DataBean.DatasBean>());
                    mProjectBean.setPageCount(0);
                }
                if (mProjectBean.getDatas().size() != 0) {
                    mProjectBean.getDatas().clear();
                }
                try {
                    ProjectBean projectBean = MiJsonUtil.getClass(response, ProjectBean.class);
                    if (projectBean.getErrorCode() == 0) {
                        List<ProjectBean.DataBean.DatasBean> data = projectBean.getData().getDatas();
                        if (data != null && data.size() != 0) {
                            mProjectBean.getDatas().addAll(data);
                            mProjectBean.setPageCount(projectBean.getData().getPageCount());
                            mProjectListData.setValue(mProjectBean);
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
