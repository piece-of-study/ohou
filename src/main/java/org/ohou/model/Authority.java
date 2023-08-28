package org.ohou.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String username;
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="username", referencedColumnName = "username")
    private User user;

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

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                ", user=" + user +
                '}';
    }
}
