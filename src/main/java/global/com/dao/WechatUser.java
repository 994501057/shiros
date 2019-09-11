package global.com.dao;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WechatUser {
    @Id
    private String open_id;
    /**
     * skey
     */
    @Column(unique=true)
    private String skey;
    /**
     * 创建时间
     */
    @Column(unique=true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    /**
     * 最后登录时间
     */
    @Column(unique=true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date last_visit_time;
    /**
     * session_key
     */
    @Column(unique=true)
    private String session_key;
    /**
     * 市
     */
    @Column(unique=true)
    private String city;
    /**
     * 省
     */
    @Column(unique=true)
    private String province;
    /**
     * 国
     */
    @Column(unique=true)
    private String country;
    /**
     * 头像
     */
    @Column(unique=true)

    private String avatar_url;
    /**
     * 性别
     */
    @Column(unique=true)

    private Integer gender;
    /**
     * 网名
     */
    @Column(unique=true)

    private String nick_name;

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_visit_time() {
        return last_visit_time;
    }

    public void setLast_visit_time(Date last_visit_time) {
        this.last_visit_time = last_visit_time;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
