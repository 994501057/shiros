package global.com.dao;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id@GeneratedValue
    private Long id;
    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String pwd;
    @Column(unique=true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
