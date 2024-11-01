package cn.cdtu.movie.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Customer extends User {
    /**
     * 余额
     */
    private BigDecimal balance;

    public Customer(long id, String loginName, String password, String userName, String sex, String phone, Date createTime, String createBy, Date dateTime, String updateBy, BigDecimal balance) {
        super(id, loginName, password, userName, sex, phone, createTime, createBy, dateTime, updateBy);
        this.balance = balance;
    }

    public Customer() {

    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
