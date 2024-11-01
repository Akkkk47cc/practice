package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Business;
import cn.cdtu.movie.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MoiveDao {
    public void  Information(Business business){
        Connection conn =null;
        String sql = "select * from movie_show a left join movie b on a.movie_id = b.id left join business c on a.business_id = c.id where business_id = ?";
        PreparedStatement pst =null;
        ResultSet rs =null;

        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setObject(1,business.getId());
            rs = pst.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                long businessId = rs.getLong("businessId");
                long number = rs.getLong("number");
                BigDecimal price = rs.getBigDecimal("price");
                System.out.println(name+businessId+number+price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pst,conn);
        }

    }

}
