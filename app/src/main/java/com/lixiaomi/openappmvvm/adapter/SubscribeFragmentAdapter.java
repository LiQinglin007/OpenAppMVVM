package com.lixiaomi.openappmvvm.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.WXArticleListBean;

import java.util.List;


/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SubscribeFragmentAdapter extends BaseQuickAdapter<WXArticleListBean.DataBean.DatasBean, BaseViewHolder> {

    public SubscribeFragmentAdapter(int layoutResId, @Nullable List<WXArticleListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WXArticleListBean.DataBean.DatasBean item) {
        helper.setText(R.id.item_wxarticle_title, item.getTitle())
                .setText(R.id.item_wxarticle_author, "时间：" + item.getNiceDate());
    }
}
