package com.lixiaomi.openappmvvm.ui;

import android.support.v4.app.Fragment;

import com.lixiaomi.baselib.eventmessage.MiEventMessage;
import com.lixiaomi.baselib.utils.MiFinalData;
import com.lixiaomi.baselib.utils.PreferenceUtils;
import com.lixiaomi.mvvmbaselib.bottom.BaseBottomActivity;
import com.lixiaomi.mvvmbaselib.bottom.BottomTabBean;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.ui.fragment.HomeFragment;
import com.lixiaomi.openappmvvm.ui.fragment.MeFragment;
import com.lixiaomi.openappmvvm.ui.fragment.SubscribeFragment;
import com.lixiaomi.openappmvvm.ui.fragment.SystemFragment;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.LinkedHashMap;

/**
 * @author Xiaomi
 */
public class MainActivity extends BaseBottomActivity {

    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }

    @Override
    public void init() {
        EventBus.getDefault().register(this);
        PreferenceUtils.setBoolean(MiFinalData.IS_OPEN_APP, true);
    }

    @Override
    public LinkedHashMap<BottomTabBean, Fragment> setItems() {
        LinkedHashMap<BottomTabBean, Fragment> mFragmentList = new LinkedHashMap<>();
        mFragmentList.put(new BottomTabBean("首页", R.drawable.icon_bottom_home_sel, R.drawable.icon_bottom_home), HomeFragment.getInstance());
        mFragmentList.put(new BottomTabBean("公众号", R.drawable.icon_bottom_sub_sel, R.drawable.icon_bottom_sub), SubscribeFragment.getInstance());
        mFragmentList.put(new BottomTabBean("体系", R.drawable.icon_bottom_sys_sel, R.drawable.icon_bottom_sys), SystemFragment.getInstance());
        mFragmentList.put(new BottomTabBean("我的", R.drawable.icon_bottom_me_sel, R.drawable.icon_bottom_me), MeFragment.getInstance());
        return mFragmentList;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getIsDownLoad(MiEventMessage message) {
        if (message.getMessageType() == MiEventMessage.SWITCH_FRAGMENT) {
            setSwitchIndex(message.getMessageInt());
        }
    }

    @Override
    public int setChooseIndex() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return R.color.default_color;
    }

    @Override
    public int setUnClickedColor() {
        return R.color.color_666;
    }

    @Override
    public int setBackGroundColor() {
        return R.color.color_white;
    }

    @Override
    public OnBottomItemClickListener setOnBottomItemClickListener() {
        return new OnBottomItemClickListener() {
            @Override
            public boolean click(int position) {
                return true;
            }
        };
    }

    @Override
    protected void initCompletion() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
