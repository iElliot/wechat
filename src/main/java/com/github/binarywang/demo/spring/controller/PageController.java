package com.github.binarywang.demo.spring.controller;

import com.github.binarywang.demo.spring.db.JdbcUtils;
import com.github.binarywang.demo.spring.util.PageStyleUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-10
 * Time: 19:11
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/detail")
    public ModelAndView getDetail(HttpServletRequest request) throws SQLException {

        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            return null;
        }
        String sql = "select * from bass_tabs where id = ?";
        JdbcUtils jdbcUtils = new JdbcUtils();
        jdbcUtils.getConnection();
        List list = new ArrayList();
        list.add(id);
        Map map = jdbcUtils.findSimpleResult(sql, list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../tabs.jsp");
        String wrapped = PageStyleUtil.autoWrap(map.get("songContent").toString().trim());//自动换行处理
        String wrapped2 = PageStyleUtil.autoWrap(wrapped);//自动换行处理
        modelAndView.addObject("song", wrapped2);
        return modelAndView;
    }

}
