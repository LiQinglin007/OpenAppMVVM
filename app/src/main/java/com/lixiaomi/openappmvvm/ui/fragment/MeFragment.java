package com.lixiaomi.openappmvvm.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lixiaomi.baselib.eventmessage.MiEventMessage;
import com.lixiaomi.baselib.utils.loadImageUtils.MiLoadImageUtil;
import com.lixiaomi.mvvmbaselib.base.BaseFragment;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.ui.activity.UtilsActivity;
import com.lixiaomi.openappmvvm.ui.activity.WebViewActivity;
import com.lixiaomi.openappmvvm.utils.FinalData;
import com.tencent.bugly.crashreport.CrashReport;


import org.greenrobot.eventbus.EventBus;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {


    private android.support.v7.widget.AppCompatImageView mMineTakePic;
    private android.support.v7.widget.AppCompatTextView mMineUtils;
    private android.support.v7.widget.AppCompatTextView mSwitchFragmentTv;
    private android.support.v7.widget.AppCompatTextView mBlogTv;
    private android.support.v7.widget.AppCompatTextView mBookTv;

    public static MeFragment getInstance() {
        return MeFragmentImplHolder.mMeFragmentImpl;
    }


    private static final class MeFragmentImplHolder {
        private final static MeFragment mMeFragmentImpl = new MeFragment();
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mMineTakePic = rootView.findViewById(R.id.mine_take_pic);
        mMineUtils = rootView.findViewById(R.id.mine_utils);
        mSwitchFragmentTv = rootView.findViewById(R.id.mine_switch_fragment);
        mBlogTv = rootView.findViewById(R.id.mine_blog);
        mBookTv = rootView.findViewById(R.id.mine_book);

        mMineUtils.setOnClickListener(this);
        mSwitchFragmentTv.setOnClickListener(this);
        mBlogTv.setOnClickListener(this);
        mBookTv.setOnClickListener(this);

        MiLoadImageUtil.loadImageCircle(getActivity(), R.drawable.headview, mMineTakePic);
    }

    @Override
    protected void startListenerData() {

    }

    @Override
    protected BaseLifeCycle createLifeCycle() {
        return null;
    }

    @Override
    protected BaseViewModel creatViewModel() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_switch_fragment:
                EventBus.getDefault().post(new MiEventMessage(MiEventMessage.SWITCH_FRAGMENT, 0));
                break;
            case R.id.mine_utils:
                CrashReport.testJavaCrash();
                startActivity(new Intent(getActivity(), UtilsActivity.class));
                break;
            case R.id.mine_blog:
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, "https://blog.csdn.net/qq_15037349")
                        .putExtra(FinalData.WEB_VIEW_TITLE, "个人博客")
                );
                break;
            case R.id.mine_book:
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra(FinalData.WEB_VIEW_URL, "https://www.jianshu.com/users/1452ccbf6187/timeline")
                        .putExtra(FinalData.WEB_VIEW_TITLE, "个人博客")
                );
                break;
            default:
                break;
        }
    }
}
