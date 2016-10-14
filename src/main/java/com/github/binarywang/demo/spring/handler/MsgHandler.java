package com.github.binarywang.demo.spring.handler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.github.binarywang.demo.spring.builder.ImageAndTextBuilder;
import com.github.binarywang.demo.spring.builder.ImageBuilder;
import com.github.binarywang.demo.spring.cache.UserCache;
import com.github.binarywang.demo.spring.db.BaseHandler;
import com.github.binarywang.demo.spring.dto.UserCacheDto;
import com.github.binarywang.demo.spring.util.ParamTypeParse;
import com.github.binarywang.demo.spring.util.ParamTypeUtil;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;
import org.apache.commons.lang3.StringUtils;

import com.github.binarywang.demo.spring.builder.TextBuilder;
import com.github.binarywang.demo.spring.service.BaseWxService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

/**
 * @author Binary Wang
 */
public abstract class MsgHandler extends AbstractHandler {

    private int index = 0;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {

        BaseWxService weixinService = (BaseWxService) wxMpService;
        String content = "公众号正在建设中...";

        /**
         * 如果输入的是歌名
         * {
         *    1.有缓存 删除原有添加新缓存
         *    2.么有缓存 添加缓存
         * }
         * 如果是页码
         * {
         *     1.有缓存 更新时间
         *     2.无缓存 --
         * }
         */

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
            // TODO: 2016/10/10 分页功能
            String value = wxMessage.getContent();
            List<Map> list = null;
            //判断是否是序号
            if (ParamTypeUtil.isInteger(value)) {
                if (UserCache.hasCache(wxMessage.getFromUser())) {
                    //根据输入序号获取歌曲id
                    index = Integer.parseInt(value);
                    if (index >= 1) {
                        index -= 1;
                    }
                    String title = "";
                    String id = "";
                    List cacheList = UserCache.getCache(wxMessage.getFromUser()).getList();
                    if (index + 1 > cacheList.size()) {
                        return new TextBuilder().build("只能输入[1]到[" + cacheList.size() + "]", wxMessage, weixinService);
                    }
                    if (cacheList != null && cacheList.size() > 0) {
                        Map m = UserCache.getCache(wxMessage.getFromUser()).getList().get(index);
                        content = m.get("songContent").toString();
                        title = m.get("songName").toString();
                        id = m.get("id").toString();
                        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
                        item.setPicUrl("http://avatar.csdn.net/3/8/D/1_wyx100.jpg");
                        item.setUrl("http://basstabs.imwork.net/page/detail?id=" + id);//http://basstabs.imwork.net/page/detail?id="+id
                        item.setDescription("");
                        item.setTitle(title);
                        return new ImageAndTextBuilder().build("11", item, wxMessage, weixinService);
                    }
                } else {
                    content = "不知道你在讲咩";
                }

            } else if (value.equals("shabi") || value.equals("煞笔") || value.equals("傻逼")) {
                content = "kao,别以为我不知道你在骂我";
            } else if (value.equals("?") || value.equals("？") || value.equals("帮助") || value.equals("help") || value.equals("帮助")
                    || value.equals("bangzhu") || value.equals("bangzu") || value.equals("爸爸帮帮我")) {
                content = "1.直接输入完整的单词搜索\n2.输入歌谱序号来查看详情\n3.可能会有智障般反应不过来的情况,请..你来打我啊";
            } else {
                UserCacheDto dto = new UserCacheDto();
                dto.setTimestamp(new Timestamp(System.currentTimeMillis()));
                dto.setFromUser(wxMessage.getFromUser());
                dto.setSongName(wxMessage.getContent());
                try {
                    list = BaseHandler.search(0, value);
                    dto.setList(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (UserCache.hasCache(wxMessage.getFromUser())) {
                    if (list.size() > 0) {
                        UserCache.updateCache(dto);
                    } else {
                        UserCache.removeCache(wxMessage.getFromUser());
                    }
                } else {
                    UserCache.addCache(dto);
                }
                try {
                    content = ParamTypeParse.List2String(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

       /* //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                && weixinService.hasKefuOnline()) {
            return WxMpXmlOutMessage
                    .TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser()).build();
        }*/
        return new TextBuilder().build(content, wxMessage, weixinService);
    }

}
