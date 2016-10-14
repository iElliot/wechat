package com.github.binarywang.demo.spring.bean;

import java.sql.Timestamp;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-10
 * Time: 10:31
 */
public class BassTabs {

    private int docId;

    private String path;

    private String songName;

    private String songIndex;

    private Timestamp createTime;

    public int getDocId() {
        return docId;
    }

    public String getPath() {
        return path;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongIndex() {
        return songIndex;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongIndex(String songIndex) {
        this.songIndex = songIndex;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
