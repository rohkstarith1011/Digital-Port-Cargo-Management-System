package com.crimsonlogic.model.implementationclasses.user;

import com.crimsonlogic.model.abstractclasses.User;

import java.util.Objects;

public class CustomsOfficer extends User {
    private String licenseNumber;
    private String inspectionZone;

    public CustomsOfficer(String userId, String userName, String userEmail, String userPhNo, String licenseNumber, String inspectionZone) {
        super(userId, userName, userEmail, userPhNo);
        this.licenseNumber = licenseNumber;
        this.inspectionZone = inspectionZone;
    }

    public CustomsOfficer() {
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getInspectionZone() {
        return inspectionZone;
    }

    public void setInspectionZone(String inspectionZone) {
        this.inspectionZone = inspectionZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomsOfficer that = (CustomsOfficer) o;
        return Objects.equals(licenseNumber, that.licenseNumber) && Objects.equals(inspectionZone, that.inspectionZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), licenseNumber, inspectionZone);
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "licenseNumber='" + licenseNumber + '\'' +
                ", inspectionZone='" + inspectionZone + '\'' +
                " ";
    }

}
