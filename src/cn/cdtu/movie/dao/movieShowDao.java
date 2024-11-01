package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Customer;
import cn.cdtu.movie.entity.MovieShow;
import cn.cdtu.movie.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class movieShowDao {
    public boolean addMoive(MovieShow moive){
        Connection conn =null;
        String sql = "insert into movie_show (business_id,movie_id,price,number,create_time,create_by) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst =null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setObject(1,moive.getBusinessId());
            pst.setObject(2,moive.getMovieId());
            pst.setObject(3,moive.getPrice());
            pst.setObject(4,moive.getNumber());
            pst.setObject(5,moive.getCreateTime());
            pst.setObject(6,moive.getCreateBy());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(null,pst,conn);
        }
    }
    public boolean deleteMoive(MovieShow moive){
        Connection conn =null;
        String sql = "delete from movie_show where id =?";
        PreparedStatement pst =null;
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setObject(1,moive.getMovieId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(null,pst,conn);
        }
    }
    public MovieShow foundprice(long movieId){

            Connection conn =null;
            String sql = "select * FROM movie_show where movie_id= ?";
            ResultSet rs =null;
            PreparedStatement pst =null;
            MovieShow movieShow=null;
            try {
                conn = JDBCUtil.getConnection();
                pst = conn.prepareStatement(sql);
                pst.setObject(1,movieId);
                rs = pst.executeQuery();
                if(rs.next()){
                   movieShow = new MovieShow();
                   movieShow.setPrice(rs.getBigDecimal("price"));



                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(rs,pst,conn);
            }

            return movieShow;



    }


}
