package com.lixiaomi.openappmvvm.model;


import com.lixiaomi.mvvmbaselib.base.BaseModel;
import com.lixiaomi.mvvmbaselib.base.MyPresenterCallBack;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/1<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public interface TreeModel extends BaseModel {
    /**
     * 获取体系类型列表
     *
     * @param myPresenterCallBack
     */
    void getTreeTypeList(MyPresenterCallBack myPresenterCallBack);

    /**
     * 获取体系下的文章列表
     *
     * @param page 页码
     * @param cId  类型id
     */
    void getTreeList(int page, String cId, MyPresenterCallBack myPresenterCallBack);

}
