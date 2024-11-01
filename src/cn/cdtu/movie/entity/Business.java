package cn.cdtu.movie.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Business extends User {
    /**
     * 营收
     */
     private BigDecimal revenue;
    /**
     * 商家名
     */
    private String shopName;
    /**
     * 商家地址
     */
    private String shopAdress;

    public Business(long id, String loginName, String password, String userName, String sex, String phone, Date createTime, String createBy, Date dateTime, String updateBy, BigDecimal revenue, String shopName, String shopAdress) {
        super(id, loginName, password, userName, sex, phone, createTime, createBy, dateTime, updateBy);
        this.revenue = revenue;
        this.shopName = shopName;
        this.shopAdress = shopAdress;
    }

    public Business() {

    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress;
    }
}
