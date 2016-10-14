package com.github.binarywang.demo.spring.builder;

import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.binarywang.demo.spring.service.BaseWxService;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

/**
 * @author Binary Wang
 */
public abstract class AbstractBuilder {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public abstract WxMpXmlOutMessage build(String content,
                                            WxMpXmlMessage wxMessage, BaseWxService service);

    public abstract WxMpXmlOutNewsMessage build(String content, WxMpXmlOutNewsMessage.Item item,
                                                WxMpXmlMessage wxMessage, BaseWxService service);
}
