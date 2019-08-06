package com.lixiaomi.openappmvvm.bean;

import java.util.List;

/**
 * @describe：公众号文章列表<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class WXArticleListBean extends BaseBean {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8764,"link":"https://mp.weixin.qq.com/s/QhOGJ51Cc0hUFX6ErGtr0w","niceDate":"2019-07-26","origin":"","prefix":"","projectLink":"","publishTime":1564070400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我在一个群分享Android 好像被我分享得没人说话了... 4期","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8763,"link":"https://mp.weixin.qq.com/s/Q2Z-e6Sd568EFRUIL5678g","niceDate":"2019-07-25","origin":"","prefix":"","projectLink":"","publishTime":1563984000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"这交互炸了系列 第十四式 之 百步穿扬","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8762,"link":"https://mp.weixin.qq.com/s/dU7no69L3cz_5iM15AA9bA","niceDate":"2019-07-24","origin":"","prefix":"","projectLink":"","publishTime":1563897600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"带你梳理一遍Android核心知识","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8761,"link":"https://mp.weixin.qq.com/s/KpLoL4TuGZezjGqVDBE2Xg","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"","publishTime":1563811200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"View.getContext() 一定返回 Activity 对象么？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8760,"link":"https://mp.weixin.qq.com/s/b42s9jc4uOInPiWK3uvAUw","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"","publishTime":1563724800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"学 Android 咋没有这样的 Flutter &ldquo;保姆&rdquo;级项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8759,"link":"https://mp.weixin.qq.com/s/eQa9CxxTtChMVZ_kdwYEcw","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563379200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"看完这篇文章,解决 APP 中 90 % 的内存异常问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8758,"link":"https://mp.weixin.qq.com/s/Rr0atgupgoeHOEV3-20WqQ","niceDate":"2019-07-17","origin":"","prefix":"","projectLink":"","publishTime":1563292800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"一篇文章带你领略Android混淆的魅力","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8757,"link":"https://mp.weixin.qq.com/s/Ilga7ktUnj3-rHRNYBitcQ","niceDate":"2019-07-15","origin":"","prefix":"","projectLink":"","publishTime":1563120000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"QQ空间说说都有弹幕咯","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8756,"link":"https://mp.weixin.qq.com/s/LXo6h_-ijKevD1tehcFXgA","niceDate":"2019-07-12","origin":"","prefix":"","projectLink":"","publishTime":1562860800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"与&ldquo;阿里&rdquo;的flutter-go双剑合璧","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8755,"link":"https://mp.weixin.qq.com/s/UlM2P4oA6DXOoiPLUNMvjw","niceDate":"2019-07-11","origin":"","prefix":"","projectLink":"","publishTime":1562774400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android冷启动优化 一顿操作猛如虎","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8754,"link":"https://mp.weixin.qq.com/s/-DnP4je21s3hBzqrtqzEHQ","niceDate":"2019-07-10","origin":"","prefix":"","projectLink":"","publishTime":1562688000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"加油吧，少年！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8753,"link":"https://mp.weixin.qq.com/s/_PKbT5LQK_MFRx9fOpHmqA","niceDate":"2019-07-09","origin":"","prefix":"","projectLink":"","publishTime":1562601600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android 踩过的几个误区 | 多线程篇","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8752,"link":"https://mp.weixin.qq.com/s/noj2QwTugCKFqfT_XaqqWA","niceDate":"2019-07-04","origin":"","prefix":"","projectLink":"","publishTime":1562169600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"大图做帧动画卡顿？不存在的！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8751,"link":"https://mp.weixin.qq.com/s/ep1CiH0yvwUrz22gOraiQg","niceDate":"2019-07-03","origin":"","prefix":"","projectLink":"","publishTime":1562083200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"总结了一些Flutter开发中的&ldquo;坑&rdquo;","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8750,"link":"https://mp.weixin.qq.com/s/jTzo9Z2El5ViSgmRXnulgQ","niceDate":"2019-07-02","origin":"","prefix":"","projectLink":"","publishTime":1561996800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"学不动了？扶你起来继续学 | 7","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8749,"link":"https://mp.weixin.qq.com/s/XHVRSZXk68h6ZhHmfh442A","niceDate":"2019-06-28","origin":"","prefix":"","projectLink":"","publishTime":1561651200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"一起来学 Android Jetpack 架构组件 Navigation","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8748,"link":"https://mp.weixin.qq.com/s/20g5tirh2jY9qfVtcl7W8A","niceDate":"2019-06-26","origin":"","prefix":"","projectLink":"","publishTime":1561478400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"给大家 3 个走心的面试建议","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8747,"link":"https://mp.weixin.qq.com/s/gHKEHwD9tMN8_TqBskh3xA","niceDate":"2019-06-25","origin":"","prefix":"","projectLink":"","publishTime":1561392000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Flutter 与 React Native 谁主沉浮？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8746,"link":"https://mp.weixin.qq.com/s/FMx-jsB6Fv8MR2-qRJ6p5A","niceDate":"2019-06-24","origin":"","prefix":"","projectLink":"","publishTime":1561305600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我来给大家回答个问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8745,"link":"https://mp.weixin.qq.com/s/B3hZtdyXtpecW0Qnq2YBOg","niceDate":"2019-06-21","origin":"","prefix":"","projectLink":"","publishTime":1561046400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"今天想感谢一个伙伴","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":39,"size":20,"total":762}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8764,"link":"https://mp.weixin.qq.com/s/QhOGJ51Cc0hUFX6ErGtr0w","niceDate":"2019-07-26","origin":"","prefix":"","projectLink":"","publishTime":1564070400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我在一个群分享Android 好像被我分享得没人说话了... 4期","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8763,"link":"https://mp.weixin.qq.com/s/Q2Z-e6Sd568EFRUIL5678g","niceDate":"2019-07-25","origin":"","prefix":"","projectLink":"","publishTime":1563984000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"这交互炸了系列 第十四式 之 百步穿扬","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8762,"link":"https://mp.weixin.qq.com/s/dU7no69L3cz_5iM15AA9bA","niceDate":"2019-07-24","origin":"","prefix":"","projectLink":"","publishTime":1563897600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"带你梳理一遍Android核心知识","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8761,"link":"https://mp.weixin.qq.com/s/KpLoL4TuGZezjGqVDBE2Xg","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"","publishTime":1563811200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"View.getContext() 一定返回 Activity 对象么？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8760,"link":"https://mp.weixin.qq.com/s/b42s9jc4uOInPiWK3uvAUw","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"","publishTime":1563724800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"学 Android 咋没有这样的 Flutter &ldquo;保姆&rdquo;级项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8759,"link":"https://mp.weixin.qq.com/s/eQa9CxxTtChMVZ_kdwYEcw","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563379200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"看完这篇文章,解决 APP 中 90 % 的内存异常问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8758,"link":"https://mp.weixin.qq.com/s/Rr0atgupgoeHOEV3-20WqQ","niceDate":"2019-07-17","origin":"","prefix":"","projectLink":"","publishTime":1563292800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"一篇文章带你领略Android混淆的魅力","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8757,"link":"https://mp.weixin.qq.com/s/Ilga7ktUnj3-rHRNYBitcQ","niceDate":"2019-07-15","origin":"","prefix":"","projectLink":"","publishTime":1563120000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"QQ空间说说都有弹幕咯","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8756,"link":"https://mp.weixin.qq.com/s/LXo6h_-ijKevD1tehcFXgA","niceDate":"2019-07-12","origin":"","prefix":"","projectLink":"","publishTime":1562860800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"与&ldquo;阿里&rdquo;的flutter-go双剑合璧","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8755,"link":"https://mp.weixin.qq.com/s/UlM2P4oA6DXOoiPLUNMvjw","niceDate":"2019-07-11","origin":"","prefix":"","projectLink":"","publishTime":1562774400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android冷启动优化 一顿操作猛如虎","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8754,"link":"https://mp.weixin.qq.com/s/-DnP4je21s3hBzqrtqzEHQ","niceDate":"2019-07-10","origin":"","prefix":"","projectLink":"","publishTime":1562688000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"加油吧，少年！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8753,"link":"https://mp.weixin.qq.com/s/_PKbT5LQK_MFRx9fOpHmqA","niceDate":"2019-07-09","origin":"","prefix":"","projectLink":"","publishTime":1562601600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android 踩过的几个误区 | 多线程篇","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8752,"link":"https://mp.weixin.qq.com/s/noj2QwTugCKFqfT_XaqqWA","niceDate":"2019-07-04","origin":"","prefix":"","projectLink":"","publishTime":1562169600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"大图做帧动画卡顿？不存在的！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8751,"link":"https://mp.weixin.qq.com/s/ep1CiH0yvwUrz22gOraiQg","niceDate":"2019-07-03","origin":"","prefix":"","projectLink":"","publishTime":1562083200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"总结了一些Flutter开发中的&ldquo;坑&rdquo;","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8750,"link":"https://mp.weixin.qq.com/s/jTzo9Z2El5ViSgmRXnulgQ","niceDate":"2019-07-02","origin":"","prefix":"","projectLink":"","publishTime":1561996800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"学不动了？扶你起来继续学 | 7","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8749,"link":"https://mp.weixin.qq.com/s/XHVRSZXk68h6ZhHmfh442A","niceDate":"2019-06-28","origin":"","prefix":"","projectLink":"","publishTime":1561651200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"一起来学 Android Jetpack 架构组件 Navigation","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8748,"link":"https://mp.weixin.qq.com/s/20g5tirh2jY9qfVtcl7W8A","niceDate":"2019-06-26","origin":"","prefix":"","projectLink":"","publishTime":1561478400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"给大家 3 个走心的面试建议","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8747,"link":"https://mp.weixin.qq.com/s/gHKEHwD9tMN8_TqBskh3xA","niceDate":"2019-06-25","origin":"","prefix":"","projectLink":"","publishTime":1561392000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Flutter 与 React Native 谁主沉浮？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8746,"link":"https://mp.weixin.qq.com/s/FMx-jsB6Fv8MR2-qRJ6p5A","niceDate":"2019-06-24","origin":"","prefix":"","projectLink":"","publishTime":1561305600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我来给大家回答个问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8745,"link":"https://mp.weixin.qq.com/s/B3hZtdyXtpecW0Qnq2YBOg","niceDate":"2019-06-21","origin":"","prefix":"","projectLink":"","publishTime":1561046400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"今天想感谢一个伙伴","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 39
         * size : 20
         * total : 762
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : 鸿洋
             * chapterId : 408
             * chapterName : 鸿洋
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 8764
             * link : https://mp.weixin.qq.com/s/QhOGJ51Cc0hUFX6ErGtr0w
             * niceDate : 2019-07-26
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1564070400000
             * superChapterId : 408
             * superChapterName : 公众号
             * tags : [{"name":"公众号","url":"/wxarticle/list/408/1"}]
             * title : 我在一个群分享Android 好像被我分享得没人说话了... 4期
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : 公众号
                 * url : /wxarticle/list/408/1
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
