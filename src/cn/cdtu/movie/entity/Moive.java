package cn.cdtu.movie.entity;

import java.util.Date;

public class Moive {
    /**
     *主键
     */
    private  long id;
    /**
     * 电影名称
     */
    private String name;
    /**
     * 剧情
     */
    private String description;
    /**
     * 导演
     */

    private String director;
    /**
     * 演员
     */
    private String actors;
    /**
     * 上映时间
     */
    private Date releaseDate;
    /**
     * 持续时间
     */
    private  double duration;
    /**
     * 制作时间
     */
    private Date createTime;
    /**
     * 制作人
     */
    private  String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新人
     */
    private String updateBy;

    public Moive() {
    }

    public Moive(long id, String name, String description, String director, String actors, Date releaseDate, double duration, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
        return "Moive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
