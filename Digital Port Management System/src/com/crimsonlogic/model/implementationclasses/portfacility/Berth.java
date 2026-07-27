package com.crimsonlogic.model.implementationclasses.portfacility;

import com.crimsonlogic.model.abstractclasses.PortFacility;
import com.crimsonlogic.model.implementationclasses.transportasset.Vessel;

import java.util.Objects;

public class Berth extends PortFacility {
    private String berthType;
    private double berthCapacity;
    private boolean occupied;

    //Berth HAS-A Vessel
    private Vessel dockedVessel;

    public Berth(String facilityId, String facilityName, String facilityLocation, String facilityStatus, String berthType, double berthCapacity, boolean occupied, Vessel dockedVessel) {
        super(facilityId, facilityName, facilityLocation, facilityStatus);
        this.berthType = berthType;
        this.berthCapacity = berthCapacity;
        this.occupied = occupied;
        this.dockedVessel = dockedVessel;
    }

    public Berth() {
    }


    public String getBerthType() {
        return berthType;
    }

    public void setBerthType(String berthType) {
        this.berthType = berthType;
    }

    public double getBerthCapacity() {
        return berthCapacity;
    }

    public void setBerthCapacity(double berthCapacity) {
        this.berthCapacity = berthCapacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vessel getDockedVessel() {
        return dockedVessel;
    }

    public void setDockedVessel(Vessel dockedVessel) {
        this.dockedVessel = dockedVessel;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "berthType='" + berthType + '\'' +
                ", berthCapacity=" + berthCapacity +
                ", occupied=" + occupied +
                ", dockedVessel={" + dockedVessel +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Berth berth = (Berth) o;
        return Double.compare(berthCapacity, berth.berthCapacity) == 0 && occupied == berth.occupied && Objects.equals(berthType, berth.berthType) && Objects.equals(dockedVessel, berth.dockedVessel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), berthType, berthCapacity, occupied, dockedVessel);
    }
}
