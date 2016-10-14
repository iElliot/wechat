package com.github.binarywang.demo.spring.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-10
 * Time: 13:00
 */
public class UserCacheDto {

    //用户编码
    private String fromUser;
    //上次请求时间
    private Timestamp timestamp;
    //请求参数
    private String songName;
    //响应结果
    private List<Map> list;


    public String getFromUser() {
        return fromUser;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getSongName() {
        return songName;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }
}
