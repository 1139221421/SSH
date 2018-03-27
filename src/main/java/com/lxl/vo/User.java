package com.lxl.vo;

import javax.persistence.*;
/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
//@Data//自动生成get方法，set方法，toString方法
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
