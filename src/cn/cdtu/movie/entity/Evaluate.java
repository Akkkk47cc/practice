package cn.cdtu.movie.entity;

import java.util.Date;

public class Evaluate {
    /**
     *下单购买的MovieId号
     */
    private long orderId;
    /**
     * 分数
     */
    private long socore;
    /**
     * 评价
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * ID
     */
   private long id;

    public Evaluate(long orderId, long socore, String remark, Date createTime, String createBy, long id) {
        this.orderId = orderId;
        this.socore = socore;
        this.remark = remark;
        this.createTime = createTime;
        this.createBy = createBy;
        this.id = id;
    }

    public Evaluate() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getSocore() {
        return socore;
    }

    public void setSocore(long socore) {
        this.socore = socore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "orderId=" + orderId +
                ", socore=" + socore +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", id=" + id +
                '}';
    }
}
