package com.lixiaomi.openappmvvm.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

import com.google.gson.Gson;
import com.lixiaomi.baselib.net.DownloadListener;
import com.lixiaomi.baselib.net.okhttp.DownloadUtil;
import com.lixiaomi.baselib.ui.chooseDateUtils.MiDayTime;
import com.lixiaomi.baselib.ui.chooseDateUtils.MiDiDiTime;
import com.lixiaomi.baselib.ui.chooseDateUtils.MiMinTime;
import com.lixiaomi.baselib.ui.dialog.MiDialog;
import com.lixiaomi.baselib.ui.dialog.dialoglist.MiDialogList;
import com.lixiaomi.baselib.ui.dialog.dialoglist.MiListInterface;
import com.lixiaomi.baselib.utils.BaseAppManager;
import com.lixiaomi.baselib.utils.LogUtils;
import com.lixiaomi.baselib.utils.MiDateUtils;
import com.lixiaomi.baselib.utils.PermissionsUtil;
import com.lixiaomi.baselib.utils.T;
import com.lixiaomi.mvvmbaselib.base.BaseActivity;
import com.lixiaomi.mvvmbaselib.base.BaseLifeCycle;
import com.lixiaomi.mvvmbaselib.base.BaseViewModel;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.NoticeBean;
import com.lixiaomi.openappmvvm.bean.UserBean;


import java.util.ArrayList;
import java.util.Date;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/2<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class UtilsActivity extends BaseActivity implements View.OnClickListener {

    private AppCompatTextView mMineChoosetime;
    private android.support.v7.widget.SwitchCompat mMineChoosetimeSw;
    private AppCompatTextView mMineChooseTimeMin;
    private AppCompatTextView mMineChooseTimeDidi;
    private AppCompatTextView mMineChoosesex;
    private AppCompatTextView mMineBottomList;
    private AppCompatTextView mMineBottomUserlist;
    private AppCompatTextView mMineSingOut;
    private android.support.v7.widget.SwitchCompat mMineSingOutSw;
    private AppCompatTextView mMineDownload;


    private LinearLayoutCompat mTopLeftLy;
    private LinearLayoutCompat mTopRightLy;
    private AppCompatTextView mTopTitleTv;
    ArrayList<MiListInterface> mBeanArrayList = new ArrayList<>();
    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    protected int setLayout() {
        return R.layout.activity_utils;
    }

    @Override
    protected BaseViewModel creatViewModel() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        mTopLeftLy = findViewById(R.id.top_back_ly);
        mTopRightLy = findViewById(R.id.top_right_ly);
        mTopTitleTv = findViewById(R.id.top_title_tv);
        mTopTitleTv.setText("常用工具");
        mTopLeftLy.setOnClickListener(this);
        mTopRightLy.setVisibility(View.INVISIBLE);

        mMineChoosetime = findViewById(R.id.mine_choosetime);
        mMineChoosetimeSw = findViewById(R.id.mine_choosetime_sw);
        mMineChooseTimeMin = findViewById(R.id.mine_choose_time_min);
        mMineChooseTimeDidi = findViewById(R.id.mine_choose_time_didi);
        mMineChoosesex = findViewById(R.id.mine_choosesex);
        mMineBottomList = findViewById(R.id.mine_bottom_list);
        mMineBottomUserlist = findViewById(R.id.mine_bottom_userlist);
        mMineSingOut = findViewById(R.id.mine_sing_out);
        mMineSingOutSw = findViewById(R.id.mine_sing_out_sw);
        mMineDownload = findViewById(R.id.mine_download);

        mMineChoosetime.setOnClickListener(this);
        mMineChooseTimeMin.setOnClickListener(this);
        mMineChooseTimeDidi.setOnClickListener(this);
        mMineChoosesex.setOnClickListener(this);
        mMineBottomList.setOnClickListener(this);
        mMineBottomUserlist.setOnClickListener(this);
        mMineSingOut.setOnClickListener(this);
        mMineDownload.setOnClickListener(this);
    }

    @Override
    protected BaseLifeCycle createLifeCycle() {
        return null;
    }

    @Override
    protected void startListenerData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_back_ly:
                finish();
                break;
            case R.id.mine_choosetime:
                //选择时间
                final boolean chooseTimeSw = mMineChoosetimeSw.isChecked();
                Date startDate;
                Date endDate;
                Date selectDate;
                if (chooseTimeSw) {
                    //今天以后
                    startDate = new Date();
                    selectDate = MiDateUtils.getDate(2020, 4, 28);
                    endDate = MiDateUtils.getDate(2038, 5, 30);
                } else {
                    selectDate = MiDateUtils.getDate(2018, 4, 28);
                    startDate = MiDateUtils.getDate(2018, 4, 1);
                    endDate = new Date();
                }
                new MiDayTime(UtilsActivity.this)
                        .builder()
                        .setStartDate(startDate)
                        .setEndDate(endDate)
                        .setSelectDate(selectDate)
                        .setType(MiDayTime.YEAR_MONTH_DAY)
                        .setTvColor(R.color.warning_color5)
                        .setCallBack(new MiDayTime.TimeDialogCallBack() {
                            @Override
                            public void callback(String year, String month, String day) {
                                mMineChoosetime.setText(chooseTimeSw ? "今天以后:" + year + month + day : "今天以前:" + year + month + day);
                            }
                        })
                        .show();
                break;
            case R.id.mine_choose_time_min:
                Date date = new Date();
                int hours = date.getHours();
                int minutes = date.getMinutes();
                new MiMinTime(UtilsActivity.this)
                        .builder()
                        .setSelectHour(hours)
                        .setSelectMin(minutes)
                        .setTextColor(R.color.warning_color1)
                        .setTimeDialogCallBack(new MiMinTime.TimeDialogCallBack() {
                            @Override
                            public void callback(String min, String hour) {
                                mMineChooseTimeMin.setText("选择时间(分钟)：    " + hour + "：" + min);
                            }
                        })
                        .show();
                break;
            case R.id.mine_choose_time_didi:
                new MiDiDiTime(UtilsActivity.this)
                        .builder()
                        .setStartHour(2)
                        .setEndHour(20)
                        .setDayNumber(5)
                        .setTextColor(R.color.warning_color3)
                        .setTimeDialogCallBack(new MiDiDiTime.TimeDialogCallBack() {
                            @Override
                            public void callback(String dateWeek, String date, String time) {
                                mMineChooseTimeDidi.setText("选择预约时间(仿滴滴)：    " + dateWeek + time + "时");
                                LogUtils.logd("选择预约时间(仿滴滴)：    " + date);
                            }
                        })
                        .show();
                break;
            case R.id.mine_choosesex:
                //选择性别
                final ArrayList<String> sexList = new ArrayList<>();
                sexList.add("男");
                sexList.add("女");
                new MiDialogList(UtilsActivity.this)
                        .builder()
                        .setTitle("选择性别")
                        .setData(sexList)
                        .setGravity(MiDialogList.MILIST_DIALOG_BOTTOM)
                        .setReturnType(MiDialogList.MILIST_RETURN_SINGLE)
                        .setCallBack(new MiDialogList.OnDialogListCallback() {
                            @Override
                            public void onListCallback(ArrayList<Integer> position) {
                                mMineChoosesex.setText("选择性别:" + sexList.get(position.get(0)));
                            }
                        })
                        .show();
                break;
            case R.id.mine_sing_out:
                if (mMineSingOutSw.isChecked()) {
                    new MiDialog(UtilsActivity.this, MiDialog.MESSAGE_TYPE)
                            .builder()
                            .setTitle("提示")
                            .setPassword(true)
                            .setMsg("确定要退出么？")
                            .setCannleButton("取消", null)
                            .setOkButton("退出", new MiDialog.DialogCallBack() {
                                @Override
                                public void dialogCallBack(String connect) {
                                    BaseAppManager.getInstance().clear();
                                    UtilsActivity.this.finish();
                                }
                            })
                            .show();
                } else {
                    new MiDialog(UtilsActivity.this, MiDialog.EDIT_TYPE)
                            .builder()
                            .setTitle("提示")
                            .setPassword(true)
                            .setMsg("确定要退出么？")
                            .setCannleButton("取消", null)
                            .setOkButton("退出", new MiDialog.DialogCallBack() {
                                @Override
                                public void dialogCallBack(String connect) {
                                    BaseAppManager.getInstance().clear();
                                    UtilsActivity.this.finish();
                                }
                            })
                            .show();
                }
                break;
            case R.id.mine_bottom_list:
                //中间弹出dialogList
                mBeanArrayList.clear();
                for (int i = 0; i < 20; i++) {
                    mBeanArrayList.add(new NoticeBean(null, "标题巴拉巴拉" + i, "内容巴拉巴拉" + i));
                }
                new MiDialogList(UtilsActivity.this)
                        .builder()
                        .setData(mBeanArrayList)
                        .setTitle("标题巴拉巴拉")
                        .setGravity(MiDialogList.MILIST_DIALOG_CENTER)
                        .setReturnType(MiDialogList.MILIST_RETURN_MULTIPLE)
                        .setCallBack(new MiDialogList.OnDialogListCallback() {
                            @Override
                            public void onListCallback(ArrayList<Integer> position) {
                                int size = position.size();
                                for (int i = 0; i < size; i++) {
                                    LogUtils.loge(TAG, new Gson().toJson(mBeanArrayList.get(position.get(i))));
                                }
                                T.shortToast(UtilsActivity.this, "您选择了" + size + "个用户，去控制台查看详情吧");

                            }
                        })
                        .show();
                break;
            case R.id.mine_bottom_userlist:
                mBeanArrayList.clear();
                for (int i = 0; i < 20; i++) {
                    mBeanArrayList.add(new UserBean("用户名称巴拉巴拉" + i, "用户性别巴拉巴拉" + i));
                }
                new MiDialogList(UtilsActivity.this)
                        .builder()
                        .setData(mBeanArrayList)
                        .setTitle("用户名称巴拉巴拉")
                        .setGravity(MiDialogList.MILIST_DIALOG_BOTTOM)
                        .setReturnType(MiDialogList.MILIST_RETURN_SINGLE)
                        .setCallBack(new MiDialogList.OnDialogListCallback() {
                            @Override
                            public void onListCallback(ArrayList<Integer> position) {
                                T.shortToast(UtilsActivity.this, new Gson().toJson(mBeanArrayList.get(position.get(0))));
                            }
                        })
                        .show();
                break;
            case R.id.mine_download:
                PermissionsUtil.getPermission(UtilsActivity.this, permissions, "下载需要读写SD卡权限", new PermissionsUtil.PermissionCallBack() {
                    @Override
                    public void onSuccess() {
                        downLoad();
                    }

                    @Override
                    public void onFail() {

                    }
                });
                break;
            default:
                break;
        }
    }

    private void downLoad() {
        new DownloadUtil("https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk", "QQ.apk", new DownloadListener() {
            @Override
            public void downStart() {
                mMineDownload.setText("下载---》正在下载");
                LogUtils.loge("开始下载");
            }

            @Override
            public void downProgress(int progress, long speed) {
                mMineDownload.setText("下载---》" + "进度下载：" + progress + "%speed:" + speed);
                LogUtils.loge("进度下载：" + progress + "speed:" + speed);
            }

            @Override
            public void downSuccess() {
                mMineDownload.setText("下载---》下载成功");
            }

            @Override
            public void downFailed(String failedDesc) {
                mMineDownload.setText("下载---》下载失败：" + failedDesc);
                LogUtils.loge("下载失败：" + failedDesc);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsUtil.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PermissionsUtil.onActivityResult(UtilsActivity.this, requestCode, resultCode, data);
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.default_color;
    }

}
