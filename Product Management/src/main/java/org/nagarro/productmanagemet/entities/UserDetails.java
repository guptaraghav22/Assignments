package org.nagarro.productmanagemet.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserDetails {
    @Id
    private String userName;

    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
