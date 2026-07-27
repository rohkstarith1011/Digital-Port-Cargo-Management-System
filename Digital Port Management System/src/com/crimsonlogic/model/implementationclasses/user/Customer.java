package com.crimsonlogic.model.implementationclasses.user;

import com.crimsonlogic.model.abstractclasses.User;
import com.crimsonlogic.model.compositionclasses.logistics.Shipment;

import java.util.Objects;

public class Customer extends User {


    private String GSTNumber;
    private Shipment shipment;
    public Customer(Shipment shipment,String userId, String userName, String userEmail, String userPhNo, String GSTNumber) {
        super(userId, userName, userEmail, userPhNo);

        this.GSTNumber = GSTNumber;
        this.shipment=shipment;
    }

    public Customer() {
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }


    public String getGSTNumber() {
        return GSTNumber;
    }

    public void setGSTNumber(String GSTNumber) {
        this.GSTNumber = GSTNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(GSTNumber, customer.GSTNumber) && Objects.equals(shipment, customer.shipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), GSTNumber, shipment);
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                ", GSTNumber='" + GSTNumber + '\'' +
                " ";
    }
}
