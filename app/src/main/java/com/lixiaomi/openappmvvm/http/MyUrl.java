package com.lixiaomi.openappmvvm.http;

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/30<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class MyUrl {
    /**
     * 首页Banner
     */
    private static final String BANNER_GET = "banner/json";
    //    article/list/1/json
    /**
     * 首页文章  可分页
     */
    private static final String ARTICLE_GET = "article/list/";
    /**
     * 首页最新项目
     */
    private static final String ARTICLE_PROJECT_GET = "article/listproject/";
//    https://wanandroid.com/wxarticle/chapters/json
    /**
     * 获取公众号列表
     */
    private static final String WX_ARTICLE_GET = "wxarticle/chapters/json";
    /**
     * 获取某个公众号下的历史文章
     * wxarticle/list/408/1/json
     */
    private static final String WX_ARTICLE_LIST_GET = "wxarticle/list/";
    /**
     * 体系类型
     */
    private static final String TREE_GET = "tree/json";
    /**
     * 体系下的文章列表
     * 这里的cid是二级分类的id
     * 0/json?cid=60
     */
    private static final String TREE_LIST_GET = "article/list/";

    public static String getBannerGet() {
        return BANNER_GET;
    }

    public static String getArticleGet() {
        return ARTICLE_GET;
    }

    public static String getArticleProjectGet() {
        return ARTICLE_PROJECT_GET;
    }

    public static String getWxArticleGet() {
        return WX_ARTICLE_GET;
    }

    public static String getWxArticleListGet() {
        return WX_ARTICLE_LIST_GET;
    }

    public static String getTreeGet() {
        return TREE_GET;
    }

    public static String getTreeListGet() {
        return TREE_LIST_GET;
    }
}
