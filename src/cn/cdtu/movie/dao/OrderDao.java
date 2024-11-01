package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Customer;
import cn.cdtu.movie.entity.Order;
import cn.cdtu.movie.entity.OrederBusiness;
import cn.cdtu.movie.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    public OrederBusiness found(Long movieShowid){
        OrederBusiness orederBusiness=null;
        Connection conn =null;
        String sql ="select * from movie_show a left JOIN customer b on a.business_id=b.id where a.id= ?";
        ResultSet rs =null;
        PreparedStatement pst =null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,movieShowid);
            rs=pst.executeQuery();
            if (rs.next()){
                orederBusiness = new OrederBusiness();
                orederBusiness.setBusinessId(rs.getLong("business_id"));
                orederBusiness.setId(rs.getLong("id"));
                orederBusiness.setNumber(rs.getLong("number"));
//                orederBusiness.setRevenue(rs.getBigDecimal("revenue"));
                orederBusiness.setPrice(rs.getBigDecimal("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JDBCUtil.close(rs,pst,conn);

        }
        return orederBusiness;
    }



}
