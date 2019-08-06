package com.lixiaomi.openappmvvm.model;


import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public interface ArticleModel  extends BaseModel {
    /**
     * 获取文章列表 可分页
     *
     * @param page                页码
     * @param myPresenterCallBack
     */
    void getArtcleList(int page, MyPresenterCallBack myPresenterCallBack);

    /**
     * 获取首页最新项目  可分页
     *
     * @param page                页码
     * @param myPresenterCallBack
     */
    void getArtcleProjectList(int page, MyPresenterCallBack myPresenterCallBack);
}
