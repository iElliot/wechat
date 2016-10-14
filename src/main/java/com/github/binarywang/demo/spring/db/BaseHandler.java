package com.github.binarywang.demo.spring.db;

import com.github.binarywang.demo.spring.bean.BassTabs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-08
 * Time: 18:18
 */
public class BaseHandler {

    private static final int getRandomSize = 10;//随机获取条数

    private static final int getTopHot = 10;//最热条数

    public static boolean save(List list) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        String sql = "insert into user_msg values(null,?,?,?,now())";
        return utils.updateByPreparedStatement(sql, list);
    }

    /**
     * 根据条件查询
     *
     * @param searchKey
     * @return
     * @throws SQLException
     */
    public static List<Map> search(int pageIndex, String searchKey) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        String sql = "select id,docId,path,songName,songIndex,songContent,createTime from bass_tabs where MATCH(songName)  AGAINST(?) limit ?,?";
        List list = new ArrayList();
        list.add("%" + searchKey + "%");
        list.add(pageIndex);
        list.add(getRandomSize);
        return utils.findModeResult(sql, list);
    }

    /**
     * 随机获取多条
     *
     * @param searchKey
     * @return
     * @throws SQLException
     */
    public static List<Map> getRandom(int pageIndex, String searchKey) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        String sql = "select id,docId,path,songName,songIndex,songContent,createTime from bass_tabs where songName like ? limit ?,?";
        List list = new ArrayList();
        list.add("%" + searchKey + "%");
        list.add(pageIndex);
        list.add(getRandomSize);
        return utils.findModeResult(sql, list);
    }

    /**
     * 根据id获取一条
     *
     * @param searchKey
     * @return
     * @throws SQLException
     */
    public static List<Map> getOne(String searchKey) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        String sql = "select id,docId,path,songName,songIndex,songContent,createTime from bass_tabs where songName like '%?%'";
        List list = new ArrayList();
        list.add(searchKey);
        return utils.findModeResult(sql, list);
    }

    /**
     * 随机获取最热top
     *
     * @param searchKey
     * @return
     * @throws SQLException
     */
    public static List<Map> getTopHot(String searchKey) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        String sql = "select id,docId,path,songName,songIndex,songContent,createTime from bass_tabs where songName like '%?%'";
        List list = new ArrayList();
        list.add(searchKey);
        return utils.findModeResult(sql, list);
    }


    public static void main(String[] args) throws SQLException {
        JdbcUtils utils = new JdbcUtils();
        utils.getConnection();
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        String sql = "insert into BassTabs values(null,?,?,?,?,now())";
        utils.updateByPreparedStatement(sql, list);
    }


}
