package com.lixiaomi.openappmvvm.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.TreeArticleListBean;
import java.util.List;


/**
 * @describe：体系文章列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemActivityAdapter extends BaseQuickAdapter<TreeArticleListBean.DataBean.DatasBean, BaseViewHolder> {

    public SystemActivityAdapter(int layoutResId, @Nullable List<TreeArticleListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TreeArticleListBean.DataBean.DatasBean item) {
        helper.setText(R.id.item_sys_article_title, item.getTitle())
                .setText(R.id.item_sys_article_author, "时间：" + item.getNiceDate());
    }
}
