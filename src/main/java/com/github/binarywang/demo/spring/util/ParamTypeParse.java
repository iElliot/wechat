package com.github.binarywang.demo.spring.util;

import java.util.List;
import java.util.Map;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-10
 * Time: 11:09
 */
public class ParamTypeParse {

    /**
     * 1.songName1
     * 2.songName2
     * ...
     *
     * @param list
     * @return
     */
    public static String List2String(List<Map> list) {
        if (list == null || list.size() == 0)
            return "找不到这个东东!";
        int i = 1;
        StringBuffer buffer = new StringBuffer();
        buffer.append("找到了下面这些:").append("\n\n");
        for (Map map : list) {
            String songName = map.get("songName").toString();
            buffer.append(i).append(".").append(songName).append("\n");
            i++;
        }
        buffer.append("\n");
        buffer.append("回复编号查看乐谱");
        System.out.println("查询结果为：" + buffer.toString());
        return buffer.toString();
    }

}
