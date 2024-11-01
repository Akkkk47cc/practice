package cn.cdtu.movie.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MovieShow {
    /**
     * 商家id
     */
   private long businessId;
    /**
     * 电影id
     */
   private long movieId;
    /**
     * 电影票价格
     */
    private BigDecimal price;
    /**
     * 电影票数量
     */
    private long number;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;

    public MovieShow(long businessId, long movieId, BigDecimal price, long number, Date createTime, String createBy) {
        this.businessId = businessId;
        this.movieId = movieId;
        this.price = price;
        this.number = number;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public MovieShow() {
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "MovieShow{" +
                "businessId=" + businessId +
                ", movieId=" + movieId +
                ", price=" + price +
                ", number=" + number +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
