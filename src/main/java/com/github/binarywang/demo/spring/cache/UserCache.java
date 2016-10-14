package com.github.binarywang.demo.spring.cache;

import com.github.binarywang.demo.spring.dto.UserCacheDto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-10
 * Time: 12:51
 */
public class UserCache {

    private static List<UserCacheDto> list = new ArrayList<UserCacheDto>();

    /**
     * 缓存用户信息
     *
     * @param userCacheDto
     * @return
     */
    public static boolean addCache(UserCacheDto userCacheDto) {
        boolean flag = false;
        for (UserCacheDto dto : list) {
            if (dto.getFromUser().equals(userCacheDto.getFromUser())) {
                flag = true;
            }
        }
        if (!flag) {
            list.add(userCacheDto);
            return true;
        }
        return false;
    }

    /**
     * 判断是否存在缓存
     * 存在则更新时间
     *
     * @param fromUser
     * @return
     */
    public static boolean hasCache(String fromUser) {
        boolean flag = false;
        for (UserCacheDto dto : list) {
            if (dto.getFromUser().equals(fromUser)) {
                dto.setTimestamp(new Timestamp(System.currentTimeMillis()));
                flag = true;
            }
        }
        return flag;
    }

    public static boolean removeCache(String fromUser) {
        boolean flag = false;
        for(Iterator it = list.iterator(); it.hasNext();) {
            UserCacheDto dto = (UserCacheDto) it.next();
            if (dto.getFromUser().equals(fromUser)) {
                it.remove();
                flag = true;
            }
        }
        return flag;
    }


    public static UserCacheDto getCache(String fromUser) {
        for (UserCacheDto dto : list) {
            if (dto.getFromUser().equals(fromUser)) {
                return dto;
            }
        }
        return null;
    }

    /**
     * 更新缓存
     *
     * @param userCacheDto
     * @return
     */
    public static boolean updateCache(UserCacheDto userCacheDto) {
        for (UserCacheDto dto : list) {
            if (dto.getFromUser().equals(userCacheDto.getFromUser())) {
                dto.setSongName(userCacheDto.getSongName());
                dto.setTimestamp(userCacheDto.getTimestamp());
                dto.setList(userCacheDto.getList());
                return true;
            }
        }
        return false;
    }

}
