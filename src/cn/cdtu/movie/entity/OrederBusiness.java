package cn.cdtu.movie.entity;

import java.math.BigDecimal;

public class OrederBusiness {
    private long id;

    private BigDecimal price;

    private BigDecimal revenue;

    private long businessId;

    private long number;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrederBusiness() {
    }

    public OrederBusiness(long id, BigDecimal price, BigDecimal revenue, long businessId, long number) {
        this.id = id;
        this.price = price;
        this.revenue = revenue;
        this.businessId = businessId;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrederBusiness{" +
                "id=" + id +
                ", price=" + price +
                ", revenue=" + revenue +
                ", businessId=" + businessId +
                ", number=" + number +
                '}';
    }
}

