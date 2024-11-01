package cn.cdtu.movie.entity;

import java.util.Date;

public class User {
    /**
     * 主键
     */
    private long id ;
    /**
     * 用户名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 性别
     */
    private String sex;
    /**
     *  手机号
     */
    private String phone;
    /**
     *  创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;

    /**
     *  更新时间
     */
    private Date updateTime;
    /**
     * 更新人
     */
    private String updateBy;

    public User(long id, String loginName, String password, String userName, String sex, String phone, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.phone = phone;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
