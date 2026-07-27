package com.crimsonlogic.model.implementationclasses.transportasset;

import com.crimsonlogic.model.abstractclasses.TransportAsset;
import com.crimsonlogic.model.compositionclasses.logistics.Cargo;
import com.crimsonlogic.model.compositionclasses.logistics.Schedule;

import java.util.Objects;

public class Vessel extends TransportAsset {
    private String vesselType;
    private String vesselFlag;
    private double vesselCapacity;
    private Cargo cargo;
    private Schedule schedule;

    public Vessel() {
    }

    public Vessel(Schedule schedule,Cargo cargo,String assetId, String assetName, String assetStatus, String vesselType, String vesselFlag, double vesselCapacity) {
        super(assetId, assetName, assetStatus);
        this.vesselType = vesselType;
        this.vesselFlag = vesselFlag;
        this.vesselCapacity = vesselCapacity;
        this.cargo=cargo;
        this.schedule=schedule;
    }

    public Cargo getCargo() {
        return cargo;
    }


    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getVesselFlag() {
        return vesselFlag;
    }

    public void setVesselFlag(String vesselFlag) {
        this.vesselFlag = vesselFlag;
    }

    public double getVesselCapacity() {
        return vesselCapacity;
    }

    public void setVesselCapacity(double vesselCapacity) {
        this.vesselCapacity = vesselCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "vesselType='" + vesselType + '\'' +
                ", vesselFlag='" + vesselFlag + '\'' +
                ", vesselCapacity=" + vesselCapacity +
                ",cargo={ "+cargo+" }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vessel vessel = (Vessel) o;
        return Double.compare(vesselCapacity, vessel.vesselCapacity) == 0 && Objects.equals(vesselType, vessel.vesselType) && Objects.equals(vesselFlag, vessel.vesselFlag) && Objects.equals(cargo, vessel.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vesselType, vesselFlag, vesselCapacity, cargo);
    }
}
