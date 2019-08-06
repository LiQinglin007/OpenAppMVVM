package com.lixiaomi.openappmvvm.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixiaomi.baselib.utils.loadImageUtils.MiLoadImageUtil;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.ProjectBean;


/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ProjectAdapter extends BaseQuickAdapter<ProjectBean.DataBean.DatasBean, BaseViewHolder> {

    public ProjectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectBean.DataBean.DatasBean item) {
        helper.setText(R.id.item_project_title, item.getTitle())
                .setText(R.id.item_project_content, item.getDesc())
                .setText(R.id.item_project_author, item.getAuthor() + "  " + item.getNiceDate());
        ImageView view = helper.getView(R.id.item_project_img);
        MiLoadImageUtil.loadImage(view.getContext(), item.getEnvelopePic(), view);
    }
}
