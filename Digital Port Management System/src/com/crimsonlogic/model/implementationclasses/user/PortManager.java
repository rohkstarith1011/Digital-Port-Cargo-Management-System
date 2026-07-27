package com.crimsonlogic.model.implementationclasses.user;

import com.crimsonlogic.model.abstractclasses.User;
import com.crimsonlogic.model.implementationclasses.portfacility.Port;

import java.util.Objects;

public class PortManager extends User {

    //PortManager HAS-A Port
    private Port managedPort;

    public PortManager(String userId, String userName, String userEmail, String userPhNo, Port managedPort) {
        super(userId, userName, userEmail, userPhNo);
        this.managedPort = managedPort;
    }


    public PortManager() {
    }

    public Port getManagedPort() {
        return managedPort;
    }

    public void setManagedPort(Port managedPort) {
        this.managedPort = managedPort;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "managedPort=" + managedPort +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PortManager that = (PortManager) o;
        return Objects.equals(managedPort, that.managedPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managedPort);
    }


}
