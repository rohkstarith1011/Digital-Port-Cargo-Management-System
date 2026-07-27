package com.crimsonlogic.utility;

public class ValidationClass {
    // Cargo
    public boolean validateCargoId(String cargoId) {
        return cargoId.matches("^CAR\\d{3}$");
    }

    // Cargo Name
    public boolean validateCargoName(String cargoName) {
        return cargoName.matches("^[A-Za-z ]+$");
    }

    // Vessel
    public boolean validateVesselId(String vesselId) {
        return vesselId.matches("^VES\\d{3}$");
    }

    // Vessel Name
    public boolean validateVesselName(String vesselName) {
        return vesselName.matches("^[A-Za-z ]+$");
    }

    // Container
    public boolean validateContainerId(String containerId) {
        return containerId.matches("^CON\\d{3}$");
    }

    // Container Type
    public boolean validateContainerType(String containerType) {
        return containerType.matches(
                "^(DRY|REEFER|TANK|OPEN_TOP)$"
        );
    }

    // Customer
    public boolean validateCustomerId(String customerId) {
        return customerId.matches("^CUS\\d{3}$");
    }

    // Email
    public boolean validateEmail(String email) {
        return email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );
    }

    // Phone Number
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches(
                "^[6-9]\\d{9}$"
        );
    }

    // GST Number
    public boolean validateGSTNumber(String gstNumber) {
        return gstNumber.matches(
                "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[A-Z0-9]{3}$"
        );
    }

    // Shipment
    public boolean validateShipmentId(String shipmentId) {
        return shipmentId.matches("^SHP\\d{3}$");
    }

    // Schedule
    public boolean validateScheduleId(String scheduleId) {
        return scheduleId.matches("^SCH\\d{3}$");
    }

    // Invoice
    public boolean validateInvoiceId(String invoiceId) {
        return invoiceId.matches("^INV\\d{3}$");
    }

    // Customs Clearance
    public boolean validateClearanceId(String clearanceId) {
        return clearanceId.matches("^CLR\\d{3}$");
    }

    // Notification
    public boolean validateNotificationId(String notificationId) {
        return notificationId.matches("^NOT\\d{3}$");
    }

    // Port
    public boolean validatePortId(String portId) {
        return portId.matches("^POR\\d{3}$");
    }

    // Berth
    public boolean validateBerthId(String berthId) {
        return berthId.matches("^BER\\d{3}$");
    }

    // Yard
    public boolean validateYardId(String yardId) {
        return yardId.matches("^YAR\\d{3}$");
    }

    // Customs Officer License Number
    public boolean validateLicenseNumber(String licenseNumber) {
        return licenseNumber.matches(
                "^[A-Z]{3}\\d{5}$"
        );
    }
}
