package com.crimsonlogic.model.compositionclasses.logistics;

import com.crimsonlogic.model.implementationclasses.transportasset.Container;
import com.crimsonlogic.model.implementationclasses.user.Customer;

public class Cargo {
    private String cargoId;
    private String cargoName;
    private String cargoType;
    private double cargoWeight;
    private String destination;
    private boolean hazardous;
    private String cargoStatus;

    private Customer customer;
    private Container container;
    private Shipment shipment;

    public Cargo() {
    }

    public Cargo(Shipment shipment,String cargoId, String cargoName, String cargoType, double cargoWeight, String destination, boolean hazardous, String cargoStatus, Customer customer, Container container) {
        this.cargoId = cargoId;
        this.cargoName = cargoName;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.destination = destination;
        this.hazardous = hazardous;
        this.cargoStatus = cargoStatus;
        this.customer = customer;
        this.container = container;
        this.shipment=shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public void setHazardous(boolean hazardous) {
        this.hazardous = hazardous;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return " " +
                "cargoId='" + cargoId + '\'' +
                "\n cargoName='" + cargoName + '\'' +
                "\n cargoType='" + cargoType + '\'' +
                "\n cargoWeight=" + cargoWeight +
                "\n destination='" + destination + '\'' +
                "\n hazardous=" + hazardous +
                "\n cargoStatus='" + cargoStatus + '\'' +
                "\n customer={ " + customer +
                "}\n container={ " + container +
                "}\n shipment={ "+shipment+"}";
    }
}
