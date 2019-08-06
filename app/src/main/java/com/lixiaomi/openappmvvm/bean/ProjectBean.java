package com.lixiaomi.openappmvvm.bean;

import java.util.List;

/**
 * @describe：首页推荐项目<br>
 * @author：Xiaomi<br>
 * @createTime：2019/7/31<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public class ProjectBean extends BaseBean {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"AlexLiuSheng","chapterId":340,"chapterName":"硬件相关","collect":false,"courseId":13,"desc":"本框架只适用于支持蓝牙3.0协议的设备进行数据连接传输，也就是通常说的经典蓝牙，通常手机与手机之间的连接都属于经典蓝牙模式范畴，而一般连接外设耳机等设备，大多 属于BLE蓝牙（低功耗蓝牙），这两种蓝牙除了名字有相同之外，通信方式、原理、协议完全不一样。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8722,"link":"http://www.wanandroid.com/blog/show/2629","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/AlexLiuSheng/EasyBluetoothFrame","publishTime":1563870177000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=340"}],"title":"一款适用经典蓝牙的快速开发框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"teprinciple","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"Kotlin开发，支持AndroidX 、Md5签名验证、自定义UI、自动删除安装包、通知栏图片自定义；适配中英文，支持Android9.0\r\n","envelopePic":"https://wanandroid.com/blogimgs/92ca6ece-6ed7-4a2e-a071-7c161f50d788.png","fresh":false,"id":8721,"link":"http://www.wanandroid.com/blog/show/2628","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/teprinciple/UpdateAppUtils","publishTime":1563870010000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"一行代码帮你搞定Android版本更新","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AICareless","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"AopArms编写了Android开发中常用的一套注解，如日志、异步处理、缓存、SP、延迟操作、定时任务、重试机制、try-catch安全机制、过滤频繁点击、拦截等，后续还会有更多更强大的注解功能加入\r\n","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8719,"link":"http://www.wanandroid.com/blog/show/2626","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/AICareless/AopArms","publishTime":1563869938000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AopArms一款基于AOP的Android注解框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cn-ljb","chapterId":385,"chapterName":"架构","collect":false,"courseId":13,"desc":"快捷、高效、低耦合的Android MVP架构。\r\n\r\n* 支持Java、Kotlin混编；\r\n* 支持自动生成代码。","envelopePic":"https://wanandroid.com/blogimgs/297e7e42-cad3-4e9c-b37b-d2d16c3fe5be.png","fresh":false,"id":8718,"link":"http://www.wanandroid.com/blog/show/2625","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/cn-ljb/mvp-kotlin","publishTime":1563869908000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=385"}],"title":"Kotlin-MVP架构 -  支持Kotlin&amp;Java混编、支持代码自动生成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mCyp","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android Jetpack + MVVM 构建的项目","envelopePic":"https://wanandroid.com/blogimgs/1b695b09-7220-4b68-ad08-3e2009335493.png","fresh":false,"id":8717,"link":"http://www.wanandroid.com/blog/show/2624","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/mCyp/Hoo","publishTime":1563869830000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"项目从零到一，Android Jetpack就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"该类库利用 Kotlin 语言特性合理封装了 Android 开发中的常用操作，同时也收集了开发过程中的常用工具类。 旨在做同样的事情，写最少的代码，提升开发效率。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8716,"link":"http://www.wanandroid.com/blog/show/2623","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/AndroidUtilCodeKTX","publishTime":1563869719000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AndroidUtilCodeKTX ！是时候提升你的开发效率了 ！(持续更新中...)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"chinalwb","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"这是一个简单的画廊实现. 受到 Flipboard App 的样式启发,总想做一个类似的效果试试. 目前实现原理特别简单, 一个自定义 view 加上内部维护的三个 bitmap 对象, 加上手势控制(ACTION_MOVE 和 fling &mdash; VelocityTracker)以及 camera.rotateX","envelopePic":"https://wanandroid.com/blogimgs/b9a57f25-fff5-46dc-8dd8-f822f17abd5b.png","fresh":false,"id":8714,"link":"http://www.wanandroid.com/blog/show/2621","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/chinalwb/flipGallery","publishTime":1563806055000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"简单实现可以翻转的画廊","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"devilsen","chapterId":401,"chapterName":"二维码","collect":false,"courseId":13,"desc":"一个非常高效的二维码识别库","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8713,"link":"http://www.wanandroid.com/blog/show/2620","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/devilsen/CZXing","publishTime":1563805665000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=401"}],"title":"媲美微信的二维码识别库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"yilylong","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"应用推出新功能需要给给用户提示指引一下.传入需要指引的View即可","envelopePic":"https://wanandroid.com/blogimgs/9e16809d-d726-45bf-838a-e80705174b90.png","fresh":false,"id":8659,"link":"http://www.wanandroid.com/blog/show/2618","niceDate":"2019-07-01","origin":"","prefix":"","projectLink":"https://github.com/yilylong/UserGuideView","publishTime":1561982959000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"用户引导view","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"simplezhli","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":" Flutter 练习项目。包括完整UI设计图，更贴近真实项目的练习。","envelopePic":"https://wanandroid.com/blogimgs/2c0ccd42-50b3-4d61-a019-c2dd4af368f0.png","fresh":false,"id":8660,"link":"http://www.wanandroid.com/blog/show/2619","niceDate":"2019-07-01","origin":"","prefix":"","projectLink":"https://github.com/simplezhli/flutter_deer","publishTime":1561982900000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":" Flutter 实战项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarGuo","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"不同于 GSYGithubAppFlutter 完整项目，本项目将逐步完善各种 Flutter 独立例子，方便新手学习上手和小问题方案解决。 目前开始逐步补全完善，主要提供一些有用或者有趣的例子，如果你也有好例子，环境提交 PR 。","envelopePic":"https://www.wanandroid.com/blogimgs/8aaf777c-a865-4359-84d3-79d6e27f2d60.png","fresh":false,"id":8655,"link":"http://www.wanandroid.com/blog/show/2615","niceDate":"2019-06-29","origin":"","prefix":"","projectLink":"https://github.com/CarGuo/GSYFlutterDemo","publishTime":1561816497000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"GSY系列 Flutter 独立学习项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"ljphawk","chapterId":314,"chapterName":"RV列表动效","collect":false,"courseId":13,"desc":"一个零耦合的侧滑菜单，支持RecyclerView、ListView、GridView等不同条目布局，支持菜单在左或在右，可选滑动阻塞，是否禁用等功能\r\n","envelopePic":"https://wanandroid.com/blogimgs/e286419c-d291-4956-87d8-236e06151142.png","fresh":false,"id":8651,"link":"http://www.wanandroid.com/blog/show/2614","niceDate":"2019-06-28","origin":"","prefix":"","projectLink":"https://github.com/ljphawk/SwipeMenuLayout","publishTime":1561729538000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=314"}],"title":"一个零耦合的侧滑菜单 SwipeMenuLayout","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wobiancao","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"使用MotionLayout实现高德地图bottomSheets效果","envelopePic":"https://www.wanandroid.com/blogimgs/3f26a3e5-097d-4198-8b21-3bc5774f1de8.png","fresh":false,"id":8607,"link":"http://www.wanandroid.com/blog/show/2611","niceDate":"2019-06-12","origin":"","prefix":"","projectLink":"https://github.com/wobiancao/sugar/blob/master/demo/README.md","publishTime":1560352487000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"使用MotionLayout实现高德地图bottomSheets效果","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"winlee28","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"根据Wan Android开放API写的flutter项目","envelopePic":"https://www.wanandroid.com/blogimgs/6afdbbd6-c7c5-4b45-83cf-3e8f73941593.png","fresh":false,"id":8606,"link":"http://www.wanandroid.com/blog/show/2610","niceDate":"2019-06-12","origin":"","prefix":"","projectLink":"https://github.com/winlee28/flutter-WanAndroid","publishTime":1560352386000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"根据Wan Android开放API写的flutter项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"liguangze","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"自学小程序，页面比较粗糙，根据泓洋大神WanAndroid的开放接口以及一些开源的框架借鉴，完成的一个小程序版本。","envelopePic":"https://wanandroid.com/blogimgs/1db48fd6-ae6b-4ca6-9dd3-0e56734964c1.png","fresh":false,"id":8580,"link":"http://www.wanandroid.com/blog/show/2608","niceDate":"2019-06-04","origin":"","prefix":"","projectLink":"https://github.com/liguangze/miniWanAndroid","publishTime":1559653736000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"玩Android版本的小程序","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":25,"size":15,"total":368}
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
         * datas : [{"apkLink":"","author":"AlexLiuSheng","chapterId":340,"chapterName":"硬件相关","collect":false,"courseId":13,"desc":"本框架只适用于支持蓝牙3.0协议的设备进行数据连接传输，也就是通常说的经典蓝牙，通常手机与手机之间的连接都属于经典蓝牙模式范畴，而一般连接外设耳机等设备，大多 属于BLE蓝牙（低功耗蓝牙），这两种蓝牙除了名字有相同之外，通信方式、原理、协议完全不一样。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8722,"link":"http://www.wanandroid.com/blog/show/2629","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/AlexLiuSheng/EasyBluetoothFrame","publishTime":1563870177000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=340"}],"title":"一款适用经典蓝牙的快速开发框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"teprinciple","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"Kotlin开发，支持AndroidX 、Md5签名验证、自定义UI、自动删除安装包、通知栏图片自定义；适配中英文，支持Android9.0\r\n","envelopePic":"https://wanandroid.com/blogimgs/92ca6ece-6ed7-4a2e-a071-7c161f50d788.png","fresh":false,"id":8721,"link":"http://www.wanandroid.com/blog/show/2628","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/teprinciple/UpdateAppUtils","publishTime":1563870010000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"一行代码帮你搞定Android版本更新","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AICareless","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"AopArms编写了Android开发中常用的一套注解，如日志、异步处理、缓存、SP、延迟操作、定时任务、重试机制、try-catch安全机制、过滤频繁点击、拦截等，后续还会有更多更强大的注解功能加入\r\n","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8719,"link":"http://www.wanandroid.com/blog/show/2626","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/AICareless/AopArms","publishTime":1563869938000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AopArms一款基于AOP的Android注解框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cn-ljb","chapterId":385,"chapterName":"架构","collect":false,"courseId":13,"desc":"快捷、高效、低耦合的Android MVP架构。\r\n\r\n* 支持Java、Kotlin混编；\r\n* 支持自动生成代码。","envelopePic":"https://wanandroid.com/blogimgs/297e7e42-cad3-4e9c-b37b-d2d16c3fe5be.png","fresh":false,"id":8718,"link":"http://www.wanandroid.com/blog/show/2625","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/cn-ljb/mvp-kotlin","publishTime":1563869908000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=385"}],"title":"Kotlin-MVP架构 -  支持Kotlin&amp;Java混编、支持代码自动生成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mCyp","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android Jetpack + MVVM 构建的项目","envelopePic":"https://wanandroid.com/blogimgs/1b695b09-7220-4b68-ad08-3e2009335493.png","fresh":false,"id":8717,"link":"http://www.wanandroid.com/blog/show/2624","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/mCyp/Hoo","publishTime":1563869830000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"项目从零到一，Android Jetpack就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"该类库利用 Kotlin 语言特性合理封装了 Android 开发中的常用操作，同时也收集了开发过程中的常用工具类。 旨在做同样的事情，写最少的代码，提升开发效率。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8716,"link":"http://www.wanandroid.com/blog/show/2623","niceDate":"2019-07-23","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/AndroidUtilCodeKTX","publishTime":1563869719000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AndroidUtilCodeKTX ！是时候提升你的开发效率了 ！(持续更新中...)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"chinalwb","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"这是一个简单的画廊实现. 受到 Flipboard App 的样式启发,总想做一个类似的效果试试. 目前实现原理特别简单, 一个自定义 view 加上内部维护的三个 bitmap 对象, 加上手势控制(ACTION_MOVE 和 fling &mdash; VelocityTracker)以及 camera.rotateX","envelopePic":"https://wanandroid.com/blogimgs/b9a57f25-fff5-46dc-8dd8-f822f17abd5b.png","fresh":false,"id":8714,"link":"http://www.wanandroid.com/blog/show/2621","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/chinalwb/flipGallery","publishTime":1563806055000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"简单实现可以翻转的画廊","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"devilsen","chapterId":401,"chapterName":"二维码","collect":false,"courseId":13,"desc":"一个非常高效的二维码识别库","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8713,"link":"http://www.wanandroid.com/blog/show/2620","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/devilsen/CZXing","publishTime":1563805665000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=401"}],"title":"媲美微信的二维码识别库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"yilylong","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"应用推出新功能需要给给用户提示指引一下.传入需要指引的View即可","envelopePic":"https://wanandroid.com/blogimgs/9e16809d-d726-45bf-838a-e80705174b90.png","fresh":false,"id":8659,"link":"http://www.wanandroid.com/blog/show/2618","niceDate":"2019-07-01","origin":"","prefix":"","projectLink":"https://github.com/yilylong/UserGuideView","publishTime":1561982959000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"用户引导view","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"simplezhli","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":" Flutter 练习项目。包括完整UI设计图，更贴近真实项目的练习。","envelopePic":"https://wanandroid.com/blogimgs/2c0ccd42-50b3-4d61-a019-c2dd4af368f0.png","fresh":false,"id":8660,"link":"http://www.wanandroid.com/blog/show/2619","niceDate":"2019-07-01","origin":"","prefix":"","projectLink":"https://github.com/simplezhli/flutter_deer","publishTime":1561982900000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":" Flutter 实战项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarGuo","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"不同于 GSYGithubAppFlutter 完整项目，本项目将逐步完善各种 Flutter 独立例子，方便新手学习上手和小问题方案解决。 目前开始逐步补全完善，主要提供一些有用或者有趣的例子，如果你也有好例子，环境提交 PR 。","envelopePic":"https://www.wanandroid.com/blogimgs/8aaf777c-a865-4359-84d3-79d6e27f2d60.png","fresh":false,"id":8655,"link":"http://www.wanandroid.com/blog/show/2615","niceDate":"2019-06-29","origin":"","prefix":"","projectLink":"https://github.com/CarGuo/GSYFlutterDemo","publishTime":1561816497000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"GSY系列 Flutter 独立学习项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"ljphawk","chapterId":314,"chapterName":"RV列表动效","collect":false,"courseId":13,"desc":"一个零耦合的侧滑菜单，支持RecyclerView、ListView、GridView等不同条目布局，支持菜单在左或在右，可选滑动阻塞，是否禁用等功能\r\n","envelopePic":"https://wanandroid.com/blogimgs/e286419c-d291-4956-87d8-236e06151142.png","fresh":false,"id":8651,"link":"http://www.wanandroid.com/blog/show/2614","niceDate":"2019-06-28","origin":"","prefix":"","projectLink":"https://github.com/ljphawk/SwipeMenuLayout","publishTime":1561729538000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=314"}],"title":"一个零耦合的侧滑菜单 SwipeMenuLayout","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wobiancao","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"使用MotionLayout实现高德地图bottomSheets效果","envelopePic":"https://www.wanandroid.com/blogimgs/3f26a3e5-097d-4198-8b21-3bc5774f1de8.png","fresh":false,"id":8607,"link":"http://www.wanandroid.com/blog/show/2611","niceDate":"2019-06-12","origin":"","prefix":"","projectLink":"https://github.com/wobiancao/sugar/blob/master/demo/README.md","publishTime":1560352487000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"使用MotionLayout实现高德地图bottomSheets效果","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"winlee28","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"根据Wan Android开放API写的flutter项目","envelopePic":"https://www.wanandroid.com/blogimgs/6afdbbd6-c7c5-4b45-83cf-3e8f73941593.png","fresh":false,"id":8606,"link":"http://www.wanandroid.com/blog/show/2610","niceDate":"2019-06-12","origin":"","prefix":"","projectLink":"https://github.com/winlee28/flutter-WanAndroid","publishTime":1560352386000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"根据Wan Android开放API写的flutter项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"liguangze","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"自学小程序，页面比较粗糙，根据泓洋大神WanAndroid的开放接口以及一些开源的框架借鉴，完成的一个小程序版本。","envelopePic":"https://wanandroid.com/blogimgs/1db48fd6-ae6b-4ca6-9dd3-0e56734964c1.png","fresh":false,"id":8580,"link":"http://www.wanandroid.com/blog/show/2608","niceDate":"2019-06-04","origin":"","prefix":"","projectLink":"https://github.com/liguangze/miniWanAndroid","publishTime":1559653736000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"玩Android版本的小程序","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 25
         * size : 15
         * total : 368
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
             * author : AlexLiuSheng
             * chapterId : 340
             * chapterName : 硬件相关
             * collect : false
             * courseId : 13
             * desc : 本框架只适用于支持蓝牙3.0协议的设备进行数据连接传输，也就是通常说的经典蓝牙，通常手机与手机之间的连接都属于经典蓝牙模式范畴，而一般连接外设耳机等设备，大多 属于BLE蓝牙（低功耗蓝牙），这两种蓝牙除了名字有相同之外，通信方式、原理、协议完全不一样。
             * envelopePic : https://wanandroid.com/resources/image/pc/default_project_img.jpg
             * fresh : false
             * id : 8722
             * link : http://www.wanandroid.com/blog/show/2629
             * niceDate : 2019-07-23
             * origin :
             * prefix :
             * projectLink : https://github.com/AlexLiuSheng/EasyBluetoothFrame
             * publishTime : 1563870177000
             * superChapterId : 294
             * superChapterName : 开源项目主Tab
             * tags : [{"name":"项目","url":"/project/list/1?cid=340"}]
             * title : 一款适用经典蓝牙的快速开发框架
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
                 * name : 项目
                 * url : /project/list/1?cid=340
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
