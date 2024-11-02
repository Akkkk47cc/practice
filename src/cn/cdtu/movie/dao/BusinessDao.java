package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Business;
import cn.cdtu.movie.entity.Moive;
import cn.cdtu.movie.entity.MovieShow;
import cn.cdtu.movie.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BusinessDao {
    public  boolean insert(Business business){
        Connection conn =null;
        String sql = "insert into business(login_name,password,user_name,sex,phone,revenue,shop_name,shop_address,create_time,create_by) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pst = null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,business.getLoginName());
            pst.setObject(2,business.getPassword());
            pst.setObject(3,business.getUserName());
            pst.setObject(4,business.getSex());
            pst.setObject(5,business.getPhone());
            pst.setObject(6,business.getRevenue());
            pst.setObject(7,business.getShopName());
            pst.setObject(8,business.getShopAdress());
            pst.setObject(9,business.getCreateTime());
            pst.setObject(10,business.getCreateBy());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(null,pst,conn);

        }

    }
    public Business businessLogin(String loginName){
        Connection conn =null;
        String sql = "select * FROM business where login_name= ?";
        ResultSet rs =null;
        PreparedStatement pst =null;
        Business business=null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,loginName);
            rs = pst.executeQuery();
            if(rs.next()){
                business= new Business();
                business.setId(rs.getLong("id"));
                business.setLoginName(rs.getString("login_name"));
                business.setPassword(rs.getString("password"));
                business.setUserName(rs.getString("user_name"));
                business.setSex(rs.getString("sex"));
                business.setPhone(rs.getString("phone"));
                business.setRevenue(rs.getBigDecimal("revenue"));
                business.setShopName(rs.getString("shop_name"));
                business.setShopAdress(rs.getString("shop_address"));
                business.setCreateTime(rs.getDate("create_time"));
                business.setCreateBy(rs.getString("create_by"));
                business.setUpdateTime(rs.getDate("update_time"));
                business.setUpdateBy(rs.getString("update_by"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pst,conn);
        }

        return business;
    }
    public Business foundrevenue(String customerName){
        Connection conn =null;
        String sql = "select * FROM business where login_name= ?";
        ResultSet rs =null;
        PreparedStatement pst =null;
        Business business=null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,customerName);
            rs = pst.executeQuery();
            if(rs.next()){
                business= new Business();
                business.setId(rs.getLong("id"));
                business.setLoginName(rs.getString("login_name"));
                business.setPassword(rs.getString("password"));
                business.setUserName(rs.getString("user_name"));
                business.setSex(rs.getString("sex"));
                business.setPhone(rs.getString("phone"));
                business.setRevenue(rs.getBigDecimal("revenue"));
                business.setShopName(rs.getString("shop_name"));
                business.setShopAdress(rs.getString("shop_address"));
                business.setCreateTime(rs.getDate("create_time"));
                business.setCreateBy(rs.getString("create_by"));
                business.setUpdateTime(rs.getDate("update_time"));
                business.setUpdateBy(rs.getString("update_by"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pst,conn);
        }

        return business;
    }
    public boolean businessBlance(BigDecimal money, long Id){
        Connection conn =null;
        String sql = "update business set revenue =? where id = ?";
        PreparedStatement pst =null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,money);
            pst.setObject(2,Id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(rs,pst,conn);
        }
    }

}
