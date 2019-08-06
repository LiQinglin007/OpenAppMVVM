package com.lixiaomi.openappmvvm.bean;

import android.os.Parcel;

import com.lixiaomi.baselib.ui.dialog.dialoglist.MiListInterface;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2018/4/13
 * 内容：
 * 最后修改：
 */

public class UserBean implements MiListInterface {

    private String UserName;
    private String UserSex;

    @Override
    public String getMiDialigListShowData() {
        return UserName+"我是拼接的内容";
    }

    public UserBean(String userName, String userSex) {
        UserName = userName;
        UserSex = userSex;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    protected UserBean(Parcel in) {
        this.UserName = in.readString();
        this.UserSex = in.readString();
    }

}
