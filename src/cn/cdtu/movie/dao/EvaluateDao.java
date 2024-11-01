package cn.cdtu.movie.dao;

import cn.cdtu.movie.entity.Customer;
import cn.cdtu.movie.entity.Evaluate;
import cn.cdtu.movie.entity.Moive;
import cn.cdtu.movie.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EvaluateDao {

        public boolean evaluate(Evaluate evaluate) {
            Connection conn = null;
            String sql = "insert into evaluate(id,order_id,socore,remark,create_time,create_by) VALUES (?,?,?,?,?,?) ";
            PreparedStatement pst = null;
            try {
                conn = JDBCUtil.getConnection();
                pst = conn.prepareStatement(sql);
                pst.setObject(1, evaluate.getId());
                pst.setObject(2, evaluate.getOrderId());
                pst.setObject(3, evaluate.getSocore());
                pst.setObject(4, evaluate.getRemark());
                pst.setObject(5, evaluate.getCreateTime());
                pst.setObject(6, evaluate.getCreateBy());
                pst.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                JDBCUtil.close(null, pst, conn);

            }


        }
    }
