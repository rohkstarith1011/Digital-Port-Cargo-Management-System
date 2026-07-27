package com.crimsonlogic.model.implementationclasses.transportasset;

import com.crimsonlogic.model.abstractclasses.TransportAsset;
import com.crimsonlogic.model.compositionclasses.logistics.Cargo;

import java.util.Objects;

public class Container extends TransportAsset {

    private String containerSize;
    private double maxCapacity;
    private String containerType;
    private Cargo cargo;

    public Container() {
    }

    public Container(String containerType,Cargo cargo,String assetId, String assetName, String assetStatus, String containerLocation, String containerSize, double maxCapacity) {
        super(assetId, assetName, assetStatus);
        this.containerSize = containerSize;
        this.maxCapacity = maxCapacity;
        this.cargo=cargo;
        this.containerType=containerType;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }





    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return " " +
                "containerSize='" + containerSize + '\'' +
                "\nmaxCapacity=" + maxCapacity +
                "\n containerType='" + containerType + '\'' +
                "\n cargo={" + cargo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Container container = (Container) o;
        return Double.compare(maxCapacity, container.maxCapacity) == 0   && Objects.equals(containerSize, container.containerSize) && Objects.equals(cargo, container.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),  containerSize, maxCapacity, cargo);
    }
}
