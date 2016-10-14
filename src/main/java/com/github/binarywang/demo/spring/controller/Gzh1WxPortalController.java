package com.github.binarywang.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.binarywang.demo.spring.service.BaseWxService;
import com.github.binarywang.demo.spring.service.Gzh1WxService;

/**
 * 第一个公众号的微信交互接口
 *
 * @author Binary Wang
 */
@RestController
@RequestMapping("/api/gzh1/portal")
public class Gzh1WxPortalController extends AbstractWxPortalController {
    @Autowired
    private Gzh1WxService wxService;

    @Override
    protected BaseWxService getWxService() {
        return this.wxService;
    }



    public static void main(String[] args) {
        System.out.println("R5nusxDQs3KpMkR6pVnLBXaUiCkQsuoG3XsKmrubRzvrnSCkUTH6dVZRpWsWkFGikIJ7Rj2cBIXTg0XmPjys5lNDciPXJRY6lWoEAUkdAs+0pgPpGBL5PnyF+uRVUonjQ8L9U47twXOl6N1LuQGJvXkQbEWb3JCGO2DRph4jSxDJ1jRnDleuQ8KIm1RZuR5xoCScPDbHziGNJ9N/EKnqsDZaQoEse5VWs9E124uShb1q1BgNgMAADWEHQ7iJZqHzC1MnRRJ81u19JIro07fPsNu9cM53/8+WGCueRJhCKmMGImBowFQdEihKfwytmLgFl0merYS11JHrm6op6sKh/mPDwDIglwMU6Bmz0p5mBsvrivHSIGQHj+aLWZiMzpRJsk3zWmzNUsPwOODG9w83fIbTlPs9ULbTeyh6c8BDztE=".length());
    }

}
