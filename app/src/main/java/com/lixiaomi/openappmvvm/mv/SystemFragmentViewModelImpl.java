package com.lixiaomi.openappmvvm.mv;

import android.arch.lifecycle.MutableLiveData;

import com.lixiaomi.baselib.config.AppConfigInIt;
import com.lixiaomi.baselib.utils.MiJsonUtil;
import com.lixiaomi.baselib.utils.NetWorkUtils;
import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.MyTreeBean;
import com.lixiaomi.openappmvvm.bean.TreeBean;
import com.lixiaomi.openappmvvm.http.HttpData;
import com.lixiaomi.openappmvvm.model.TreeModelmpl;
import com.lixiaomi.openappmvvm.ui.fragment.SystemFragmentLifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemFragmentViewModelImpl extends BaseViewModel<BaseModel, SystemFragmentLifecycle> implements SystemFragmentViewModel {

    private MutableLiveData<ArrayList<MyTreeBean>> mTreeData = new MutableLiveData<>();
    private ArrayList<MyTreeBean> mTreeList = new ArrayList<>();

    @Override
    protected ArrayList createModelList() {
        ArrayList<BaseModel> models = new ArrayList<>();
        models.add(new TreeModelmpl());
        return models;
    }

    public MutableLiveData<ArrayList<MyTreeBean>> getmTreeData() {
        return mTreeData;
    }

    @Override
    public void getTreeTypeList() {
        mShowLoading.setValue(true);
        ((TreeModelmpl) getModelList().get(0)).getTreeTypeList(new MyPresenterCallBack() {
            @Override
            public void success(int code, String response) {
                mShowLoading.setValue(false);
                mTreeList.clear();
                try {
                    TreeBean treeBean = MiJsonUtil.getClass(response, TreeBean.class);
                    if (treeBean.getErrorCode() == 0) {
                        List<TreeBean.DataBean> data = treeBean.getData();
                        List<MyTreeBean> myDataList = new ArrayList<>();
                        if (data != null && data.size() != 0) {
                            for (int i = 0; i < data.size(); i++) {
                                TreeBean.DataBean dataBean = data.get(i);
                                List<TreeBean.DataBean.ChildrenBean> children = dataBean.getChildren();
                                List<MyTreeBean.ChildrenBean> myChildrenList = new ArrayList<>();
                                for (int i1 = 0; i1 < children.size(); i1++) {
                                    TreeBean.DataBean.ChildrenBean childrenBean = children.get(i1);
                                    MyTreeBean.ChildrenBean myChildrenBean = new MyTreeBean.ChildrenBean();
                                    myChildrenBean.setChildren(childrenBean.getChildren());
                                    myChildrenBean.setCourseId(childrenBean.getCourseId());
                                    myChildrenBean.setId(childrenBean.getId());
                                    myChildrenBean.setName(childrenBean.getName());
                                    myChildrenBean.setOrder(childrenBean.getOrder());
                                    myChildrenBean.setParentChapterId(childrenBean.getParentChapterId());
                                    myChildrenBean.setUserControlSetTop(childrenBean.isUserControlSetTop());
                                    myChildrenBean.setVisible(childrenBean.getVisible());
                                    myChildrenBean.setParentPosition(i);
                                    myChildrenBean.setPosition(i1);
                                    myChildrenList.add(myChildrenBean);
                                }
                                MyTreeBean myTreeBean = new MyTreeBean();
                                myTreeBean.setPosition(i);
                                myTreeBean.setChildren(myChildrenList);
                                myTreeBean.setVisible(dataBean.getVisible());
                                myTreeBean.setCourseId(dataBean.getCourseId());
                                myTreeBean.setId(dataBean.getId());
                                myTreeBean.setName(dataBean.getName());
                                myTreeBean.setOrder(dataBean.getOrder());
                                myTreeBean.setParentChapterId(dataBean.getParentChapterId());
                                myTreeBean.setUserControlSetTop(dataBean.isUserControlSetTop());
                                myTreeBean.setSubItems(myChildrenList);
                                myDataList.add(myTreeBean);
                            }
                            mTreeList.addAll(myDataList);
                            mTreeData.setValue(mTreeList);
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
