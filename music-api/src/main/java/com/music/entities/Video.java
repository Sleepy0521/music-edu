package com.music.entities;

import java.util.Date;

public class Video {
    private Integer id;

    private String author;

    private String url;

    private Date updateTime;

    private Integer typeId;

    private String title;

    private Integer playTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(Integer playTimes) {
        this.playTimes = playTimes;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", updateTime=" + updateTime +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", playTimes=" + playTimes +
                '}';
    }
}