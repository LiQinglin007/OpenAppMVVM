package com.lixiaomi.openappmvvm.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ArticleBean;

import java.util.List;

/**
 * @describe：文章列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ArticleAdapter extends BaseQuickAdapter<ArticleBean.DataBean.DatasBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId, @Nullable List<ArticleBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleBean.DataBean.DatasBean item) {
        helper.setText(R.id.item_article_title, item.getTitle())
                .setText(R.id.item_article_author, item.getAuthor() + "  " + item.getNiceDate())
                .setText(R.id.item_article_type, item.getSuperChapterName());
    }
}
