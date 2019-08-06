package com.lixiaomi.openappmvvm.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.lixiaomi.baselib.utils.loadImageUtils.MiLoadImageUtil;
import com.lixiaomi.openappmvvm.R;
import com.lixiaomi.openappmvvm.bean.BannerBean;


/**
 * @describe：Banner<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class BannerHolderView extends Holder<BannerBean.DataBean> {
    private ImageView imageView;

    public BannerHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        imageView = itemView.findViewById(R.id.ivPost);
    }

    @Override
    public void updateUI(BannerBean.DataBean data) {
        MiLoadImageUtil.loadImage(imageView.getContext(), data.getImagePath(), imageView);
    }
}
