package com.lixiaomi.openappmvvm.mv;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/8/6<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public interface SubscribeFragmentViewModel {
    /**
     * 获取公众号列表
     */
    void getWXAuthorList();

    /**
     * 获取公众号下的文章列表
     *
     * @param authorId 公众号id
     * @param page     页码
     */
    void getWXArticleList(boolean showLoading, String authorId, int page);
}
