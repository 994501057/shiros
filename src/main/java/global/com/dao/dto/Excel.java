package global.com.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class Excel implements Serializable {

        private static final long serialVersionUID = 1L;

        private String userid;


        private String username;


        private String email;


        private String password;


        private String role;
        private Date datetimes;

    public Date getDatetimes() {
        return datetimes;
    }

    public void setDatetimes(Date datetimes) {
        this.datetimes = datetimes;
    }

    public Excel() {
        }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Excel(Excel user){
            this.userid = user.getUserid();
            this.username = user.getUsername();
            this.role = user.getRole();
            this.email = user.getEmail();
            this.password = user.getPassword();
        }


}
