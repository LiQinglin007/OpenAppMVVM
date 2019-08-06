package com.lixiaomi.openappmvvm.bean;

import com.lixiaomi.baselib.ui.dialog.dialoglist.MiListInterface;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2018/3/31
 * 内容：
 * 最后修改：
 */

public class NoticeBean implements MiListInterface {

    /**
     * 公告id
     */
    Long NoticeId;
    /**
     * 公告标题
     */
    String NoticeTitle;
    /**
     * 公告内容
     */
    String NoticeContent;


    public NoticeBean(Long NoticeId, String NoticeTitle, String NoticeContent) {
        this.NoticeId = NoticeId;
        this.NoticeTitle = NoticeTitle;
        this.NoticeContent = NoticeContent;
    }

    public NoticeBean() {
    }

    public Long getNoticeId() {
        return this.NoticeId;
    }

    public void setNoticeId(Long NoticeId) {
        this.NoticeId = NoticeId;
    }

    public String getNoticeTitle() {
        return this.NoticeTitle;
    }

    public void setNoticeTitle(String NoticeTitle) {
        this.NoticeTitle = NoticeTitle;
    }

    public String getNoticeContent() {
        return this.NoticeContent;
    }

    public void setNoticeContent(String NoticeContent) {
        this.NoticeContent = NoticeContent;
    }

    @Override
    public String getMiDialigListShowData() {
        return NoticeTitle;
    }
}
