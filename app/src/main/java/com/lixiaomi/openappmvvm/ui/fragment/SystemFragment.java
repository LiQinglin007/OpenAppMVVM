package com.lixiaomi.openappmvvm.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lixiaomi.baselib.utils.T;
import com.lixiaomi.mvvmbaselib.base.BaseFragment;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.adapter.SystemFragmentAdapter;
import com.lixiaomi.openappmvvm.bean.MyTreeBean;
import com.lixiaomi.openappmvvm.databinding.FragmentSystemBinding;
import com.lixiaomi.openappmvvm.mv.SystemFragmentViewModelImpl;
import com.lixiaomi.openappmvvm.ui.activity.SystemListActivity;
import com.lixiaomi.openappmvvm.utils.FinalData;

import java.util.ArrayList;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemFragment extends BaseFragment<SystemFragmentLifecycle, FragmentSystemBinding, SystemFragmentViewModelImpl> {


    private android.support.v7.widget.RecyclerView mSystemRecy;
    private SystemFragmentAdapter mSystemFragmentAdapter;
    private ArrayList<MultiItemEntity> mListData = new ArrayList<>();

    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;

    public static SystemFragment getInstance() {
        return SystemFragmentImplHolder.mSystemFragmentImpl;
    }


    private static final class SystemFragmentImplHolder {
        private final static SystemFragment mSystemFragmentImpl = new SystemFragment();
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mTopLeftLy = rootView.findViewById(R.id.top_back_ly);
        mTopRightLy = rootView.findViewById(R.id.top_right_ly);
        mTopTitleTv = rootView.findViewById(R.id.top_title_tv);

        mTopTitleTv.setText("体系");
        mTopLeftLy.setVisibility(View.INVISIBLE);
        mTopRightLy.setVisibility(View.INVISIBLE);

        mSystemRecy = rootView.findViewById(R.id.system_recy);
        mSystemRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSystemFragmentAdapter = new SystemFragmentAdapter(mListData);
        mSystemRecy.setAdapter(mSystemFragmentAdapter);


        mSystemFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getItem(position) instanceof MyTreeBean.ChildrenBean) {
                    startActivity(new Intent(getActivity(), SystemListActivity.class)
                            .putExtra(FinalData.SYSTEM_TYPE_ID, ((MyTreeBean.ChildrenBean) adapter.getItem(position)).getId())
                            .putExtra(FinalData.SYSTEM_TYPE_TITLE, ((MyTreeBean.ChildrenBean) adapter.getItem(position)).getName())
                    );
                }
            }
        });

        mViewModel.getTreeTypeList();
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

        mViewModel.getmTreeData().observe(this, new Observer<ArrayList<MyTreeBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MyTreeBean> myTreeBeans) {
                mListData.clear();
                mListData.addAll(myTreeBeans);
                mSystemFragmentAdapter.replaceData(mListData);
            }
        });
    }

    @Override
    protected SystemFragmentLifecycle createLifeCycle() {
        return new SystemFragmentLifecycle(getActivity());
    }

    @Override
    protected SystemFragmentViewModelImpl creatViewModel() {
        return ViewModelProviders.of(SystemFragment.getInstance()).get(SystemFragmentViewModelImpl.class);
    }
}
