package com.lixiaomi.openappmvvm.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.MyTreeBean;

import java.util.List;

/**
 * @describe：体系类型<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class SystemFragmentAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    /**
     * 一级分类
     */
    public static final int TYPE_LEVEL_0 = 0;
    /**
     * 二级分类
     */
    public static final int TYPE_LEVEL_1 = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SystemFragmentAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_tree1);
        addItemType(TYPE_LEVEL_1, R.layout.item_tree2);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        int itemViewType = helper.getItemViewType();
        if (itemViewType == TYPE_LEVEL_0) {
            final MyTreeBean dataBean = (MyTreeBean) item;
            helper.setText(R.id.item_tree_lv0, dataBean.getName());
            helper.setImageResource(R.id.item_tree_lv0_img, dataBean.isExpanded() ? R.drawable.arrow_r : R.drawable.arrow_b);
            helper.setVisible(R.id.item_tree_img, dataBean.isExpanded() ? true : false);
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = helper.getAdapterPosition();
                    if (dataBean.isExpanded()) {
                        collapse(pos);
                    } else {
                        expand(pos);
                    }
                }
            });
        } else if (itemViewType == TYPE_LEVEL_1) {
            MyTreeBean.ChildrenBean childrenBean = (MyTreeBean.ChildrenBean) item;
            helper.setText(R.id.item_tree_lv1, "· " + childrenBean.getName());
        }
    }
}
