package com.crimsonlogic.model.compositionclasses.administration;

import com.crimsonlogic.model.compositionclasses.logistics.Cargo;
import com.crimsonlogic.model.implementationclasses.user.CustomsOfficer;

import java.time.LocalDate;
import java.util.Objects;

public class CustomsClearance {
    private String clearanceId;
    private String clearanceStatus;
    private LocalDate inspectionDate;
    private LocalDate clearanceDate;

    //CustomsClearance Has-A CustomsOfficer
    private CustomsOfficer customsOfficer;
    private Cargo cargo;

    public CustomsClearance(Cargo cargo,String clearanceId, String clearanceStatus, LocalDate inspectionDate, LocalDate clearanceDate, CustomsOfficer customsOfficer) {
        this.clearanceId = clearanceId;
        this.clearanceStatus = clearanceStatus;
        this.inspectionDate = inspectionDate;
        this.clearanceDate = clearanceDate;
        this.customsOfficer = customsOfficer;
        this.cargo=cargo;
    }

    public CustomsClearance() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getClearanceId() {
        return clearanceId;
    }

    public void setClearanceId(String clearanceId) {
        this.clearanceId = clearanceId;
    }

    public String getClearanceStatus() {
        return clearanceStatus;
    }

    public void setClearanceStatus(String clearanceStatus) {
        this.clearanceStatus = clearanceStatus;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public LocalDate getClearanceDate() {
        return clearanceDate;
    }

    public void setClearanceDate(LocalDate clearanceDate) {
        this.clearanceDate = clearanceDate;
    }

    public CustomsOfficer getCustomsOfficer() {
        return customsOfficer;
    }

    public void setCustomsOfficer(CustomsOfficer customsOfficer) {
        this.customsOfficer = customsOfficer;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "clearanceId= " + clearanceId +
                "\n clearanceStatus= " + clearanceStatus +
                "\n inspectionDate= " + inspectionDate +
                "\n clearanceDate= " + clearanceDate +
                "\n customsOfficer={" + customsOfficer +
                "}"+ " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomsClearance that = (CustomsClearance) o;
        return Objects.equals(clearanceId, that.clearanceId) && Objects.equals(clearanceStatus, that.clearanceStatus) && Objects.equals(inspectionDate, that.inspectionDate) && Objects.equals(clearanceDate, that.clearanceDate) && Objects.equals(customsOfficer, that.customsOfficer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clearanceId, clearanceStatus, inspectionDate, clearanceDate, customsOfficer);
    }
}
