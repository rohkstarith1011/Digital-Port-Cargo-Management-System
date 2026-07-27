package com.crimsonlogic.model.abstractclasses;

import java.util.Objects;

public abstract class PortFacility {
    private String facilityId;
    private String facilityName;
    private String facilityLocation;
    private String facilityStatus;

    public PortFacility() {
    }

    public PortFacility(String facilityId, String facilityName, String facilityLocation, String facilityStatus) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityLocation = facilityLocation;
        this.facilityStatus = facilityStatus;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityLocation() {
        return facilityLocation;
    }

    public void setFacilityLocation(String facilityLocation) {
        this.facilityLocation = facilityLocation;
    }

    public String getFacilityStatus() {
        return facilityStatus;
    }

    public void setFacilityStatus(String facilityStatus) {
        this.facilityStatus = facilityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortFacility that = (PortFacility) o;
        return Objects.equals(facilityId, that.facilityId) && Objects.equals(facilityName, that.facilityName) && Objects.equals(facilityLocation, that.facilityLocation) && Objects.equals(facilityStatus, that.facilityStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityId, facilityName, facilityLocation, facilityStatus);
    }

    @Override
    public String toString() {
        return "\n" +
                "Id='" + facilityId +
                "\nName='" + facilityName +
                "\nLocation='" + facilityLocation +
                "\nStatus='" + facilityStatus +
                " ";
    }
}
