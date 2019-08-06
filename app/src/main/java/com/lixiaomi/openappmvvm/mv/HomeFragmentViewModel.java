package com.lixiaomi.openappmvvm.mv;

import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.ui.fragment.HomeFragmentLifecycle;

import java.util.ArrayList;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class HomeFragmentViewModel extends BaseViewModel<BaseModel, HomeFragmentLifecycle> {

    @Override
    protected ArrayList<BaseModel> createModelList() {
        return null;
    }
}
