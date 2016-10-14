package com.github.binarywang.demo.spring.builder;

import com.github.binarywang.demo.spring.service.BaseWxService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;

/**
 * @author MickZhang@tcl.com
 */
public class ImageAndTextBuilder extends AbstractBuilder {

    @Override
    public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, BaseWxService service) {
        return null;
    }

    @Override
    public WxMpXmlOutNewsMessage build(String content, WxMpXmlOutNewsMessage.Item item, WxMpXmlMessage wxMessage, BaseWxService service) {
        WxMpXmlOutNewsMessage m = WxMpXmlOutMessage.NEWS().addArticle(item)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();

        return m;
    }
}
