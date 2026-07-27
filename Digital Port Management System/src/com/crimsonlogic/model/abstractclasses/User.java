package com.crimsonlogic.model.abstractclasses;

import java.util.Objects;

public abstract class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPhNo;

    public User(String userId, String userName, String userEmail, String userPhNo) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhNo = userPhNo;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhNo() {
        return userPhNo;
    }

    public void setUserPhNo(String userPhNo) {
        this.userPhNo = userPhNo;
    }

    @Override
    public String toString() {
        return "\n" +
                "userId= " + userId +
                "\n userName= " + userName +
                "\n userEmail= " + userEmail +
                "\nuserPhNo= " + userPhNo +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPhNo, user.userPhNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, userPhNo);
    }
}
