package cn.cdtu.movie.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     * 客户Id
     */
    private long id;
    /**
     * 商家ID
     */
    private long customerId;
    /**
     * 电影ID
     */
    private long movieShowId;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单数量
     */
    private BigDecimal orderAmount;
    /**
     * 状态
     */
    private long status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 商家营收
     * @param id
     * @param customerId
     * @param movieShowId
     * @param orderNo
     * @param orderAmount
     * @param status
     * @param createTime
     * @param createBy
     */
    private BigDecimal revenue;

    /**
     * 客户资金
     * @param id
     * @param customerId
     * @param movieShowId
     * @param orderNo
     * @param orderAmount
     * @param status
     * @param createTime
     * @param createBy
     */
    private BigDecimal balance;

    public Order(long id, long customerId, long movieShowId, String orderNo, BigDecimal orderAmount, long status, Date createTime, String createBy, BigDecimal revenue, BigDecimal balance) {
        this.id = id;
        this.customerId = customerId;
        this.movieShowId = movieShowId;
        this.orderNo = orderNo;
        this.orderAmount = orderAmount;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.revenue = revenue;
        this.balance = balance;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getMovieShowId() {
        return movieShowId;
    }

    public void setMovieShowId(long movieShowId) {
        this.movieShowId = movieShowId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
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

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", movieShowId=" + movieShowId +
                ", orderNo='" + orderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", status=" + status +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", revenue=" + revenue +
                ", balance=" + balance +
                '}';
    }
}
