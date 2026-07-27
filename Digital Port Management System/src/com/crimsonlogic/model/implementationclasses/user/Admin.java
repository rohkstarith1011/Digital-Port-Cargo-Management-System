package com.crimsonlogic.model.implementationclasses.user;

import com.crimsonlogic.model.abstractclasses.User;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends User {

    private LocalDate joiningDate;

    public Admin() {
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "joiningDate=" + joiningDate +
                " ";
    }

    public Admin(String userId, String userName, String userEmail, String userPhNo, LocalDate joiningDate) {
        super(userId, userName, userEmail, userPhNo);
        this.joiningDate = joiningDate;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(joiningDate, admin.joiningDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), joiningDate);
    }
}
