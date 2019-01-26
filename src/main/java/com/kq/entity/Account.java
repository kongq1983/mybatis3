package com.kq.entity;

/**
 * Account
 *
 * @author kq
 * @date 2019-01-26
 */
public class Account {

    private String id;
    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
