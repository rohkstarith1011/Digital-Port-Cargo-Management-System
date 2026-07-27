package com.crimsonlogic.model.compositionclasses.logistics;

import com.crimsonlogic.model.compositionclasses.administration.CustomsClearance;
import com.crimsonlogic.model.compositionclasses.administration.Invoice;
import com.crimsonlogic.model.compositionclasses.administration.Notification;
import com.crimsonlogic.model.implementationclasses.transportasset.Vessel;
import com.crimsonlogic.model.implementationclasses.user.Customer;

import java.time.LocalDate;
import java.util.Objects;

public class Shipment {
    private String shipmentId;
    private LocalDate shipmentDate;
    private LocalDate expectedDeliveryDate;
    private String shipmentStatus;

    //Shipment HAS-A Customer
    private Customer customer;

    //Shipment HAS-A Vessel
    private Vessel vessel;

    //Shipment HAS-A Schedule
    private Schedule schedule;
    //Shipment HAS-A Invoice
    private Invoice invoice;
    //Shipment HAS-A CustomsClearance
    private CustomsClearance customsClearance;
    //Shipment HAS-A Notification
    private Notification notification;

    private Cargo cargo;

    public Shipment(Cargo cargo,String shipmentId, LocalDate shipmentDate, LocalDate expectedDeliveryDate, String shipmentStatus, Customer customer, Vessel vessel, Schedule schedule, Invoice invoice, CustomsClearance customsClearance, Notification notification) {
        this.shipmentId = shipmentId;
        this.shipmentDate = shipmentDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.shipmentStatus = shipmentStatus;
        this.customer = customer;
        this.vessel = vessel;
        this.schedule = schedule;
        this.invoice = invoice;
        this.customsClearance = customsClearance;
        this.notification = notification;
        this.cargo=cargo;
    }

    public Shipment() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public CustomsClearance getCustomsClearance() {
        return customsClearance;
    }

    public void setCustomsClearance(CustomsClearance customsClearance) {
        this.customsClearance = customsClearance;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return
                "shipmentId='" + shipmentId + '\'' +
                "\n shipmentDate=" + shipmentDate +
                "\nexpectedDeliveryDate=" + expectedDeliveryDate +
                "\nshipmentStatus='" + shipmentStatus + '\'' +
                "\ncustomer={" + customer +
                "}\n vessel={" + vessel +
                "}\n schedule={" + schedule +
                "}\n invoice={" + invoice +
                "}\n customsClearance={" + customsClearance +
                "}\n notification={" + notification +
                "}\n cargo={"+cargo+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(shipmentId, shipment.shipmentId) && Objects.equals(shipmentDate, shipment.shipmentDate) && Objects.equals(expectedDeliveryDate, shipment.expectedDeliveryDate) && Objects.equals(shipmentStatus, shipment.shipmentStatus) && Objects.equals(customer, shipment.customer) && Objects.equals(vessel, shipment.vessel) && Objects.equals(schedule, shipment.schedule) && Objects.equals(invoice, shipment.invoice) && Objects.equals(customsClearance, shipment.customsClearance) && Objects.equals(notification, shipment.notification) && Objects.equals(cargo, shipment.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId, shipmentDate, expectedDeliveryDate, shipmentStatus, customer, vessel, schedule, invoice, customsClearance, notification, cargo);
    }
}
