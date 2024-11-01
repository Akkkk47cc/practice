package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Customer;
import cn.cdtu.movie.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
    public  boolean insert(Customer customer){
        Connection conn =null;
        String sql = "insert into customer(login_name,password,user_name,sex,phone,balance,create_time,create_by) VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement pst = null;
        try {
             conn = JDBCUtil.getConnection();
             pst = conn.prepareStatement(sql);
             pst.setObject(1,customer.getLoginName());
             pst.setObject(2,customer.getPassword());
             pst.setObject(3,customer.getUserName());
             pst.setObject(4,customer.getSex());
             pst.setObject(5,customer.getPhone());
             pst.setObject(6,customer.getBalance());
             pst.setObject(7,customer.getCreateTime());
             pst.setObject(8,customer.getCreateBy());
             pst.executeUpdate();
             return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(null,pst,conn);

        }

    }
public Customer customerLogin(String loginName){
    Connection conn =null;
    String sql = "select * FROM customer where login_name= ?";
    ResultSet rs =null;
    PreparedStatement pst =null;
    Customer customer=null;
    try {
         conn = JDBCUtil.getConnection();
         pst = conn.prepareStatement(sql);
         pst.setObject(1,loginName);
         rs = pst.executeQuery();
         if(rs.next()){
             customer= new Customer();
             customer.setId(rs.getLong("id"));
             customer.setLoginName(rs.getString("login_name"));
             customer.setPassword(rs.getString("password"));
             customer.setUserName(rs.getString("user_name"));
             customer.setSex(rs.getString("sex"));
             customer.setPhone(rs.getString("phone"));
             customer.setBalance(rs.getBigDecimal("balance"));
             customer.setCreateTime(rs.getDate("create_time"));
             customer.setCreateBy(rs.getString("create_by"));
             customer.setUpdateBy(rs.getString("update_by"));
             customer.setUpdateTime(rs.getDate("update_time"));



         }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(rs,pst,conn);
    }

    return customer;
}
public boolean CustomerBlance(BigDecimal money,long Id){
    Connection conn =null;
    String sql = "update customer set balance =? where id = ?";
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
    public Customer customermoney(long Id){
        Connection conn =null;
        String sql = "select * FROM customer where id= ?";
        ResultSet rs =null;
        PreparedStatement pst =null;
        Customer customer=null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,Id);
            rs = pst.executeQuery();
            if(rs.next()){
                customer= new Customer();
                customer.setId(rs.getLong("id"));
                customer.setLoginName(rs.getString("login_name"));
                customer.setPassword(rs.getString("password"));
                customer.setUserName(rs.getString("user_name"));
                customer.setSex(rs.getString("sex"));
                customer.setPhone(rs.getString("phone"));
                customer.setBalance(rs.getBigDecimal("balance"));
                customer.setCreateTime(rs.getDate("create_time"));
                customer.setCreateBy(rs.getString("create_by"));
                customer.setUpdateBy(rs.getString("update_by"));
                customer.setUpdateTime(rs.getDate("update_time"));



            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pst,conn);
        }

        return customer;
    }



}
