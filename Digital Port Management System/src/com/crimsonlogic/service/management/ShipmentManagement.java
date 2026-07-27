package com.crimsonlogic.service.management;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.compositionclasses.administration.CustomsClearance;
import com.crimsonlogic.model.compositionclasses.administration.Invoice;
import com.crimsonlogic.model.compositionclasses.administration.Notification;
import com.crimsonlogic.model.compositionclasses.logistics.Cargo;
import com.crimsonlogic.model.compositionclasses.logistics.Schedule;
import com.crimsonlogic.model.compositionclasses.logistics.Shipment;
import com.crimsonlogic.model.implementationclasses.transportasset.Vessel;
import com.crimsonlogic.model.implementationclasses.user.Customer;
import com.crimsonlogic.service.interfaces.Manageable;
import com.crimsonlogic.service.operations.ScheduleManagement;
import com.crimsonlogic.utility.ValidationClass;

import java.time.LocalDate;
import java.util.*;


public class ShipmentManagement implements Manageable {
    ValidationClass regex = new ValidationClass();

    private static ArrayList<Shipment> shipmentList =
            new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    @Override
    public void add() {

        try {

            System.out.print("Enter Shipment Id : ");

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            boolean exists =
                    shipmentList.stream()
                            .anyMatch(
                                    shipment ->
                                            shipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            );

            if (exists) {

                System.out.println(
                        "Shipment Already Exists"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Shipment Date (yyyy-MM-dd) : "
            );

            LocalDate shipmentDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            System.out.print(
                    "Enter Expected Delivery Date (yyyy-MM-dd) : "
            );

            LocalDate expectedDeliveryDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            if (expectedDeliveryDate.isBefore(shipmentDate)) {

                throw new InvalidDataException(
                        "Expected Delivery Date Cannot Be Before Shipment Date"
                );
            }

            System.out.print(
                    "Enter Shipment Status : SCHEDULED\n" +
                            "LOADED\n" +
                            "IN_TRANSIT\n" +
                            "ARRIVED\n" +
                            "CUSTOMS_CLEARANCE\n" +
                            "DELIVERED\n" +
                            "DELAYED"
            );

            String shipmentStatus =
                    scanner.nextLine().toUpperCase();

            Shipment shipment =
                    new Shipment();
            System.out.print(
                    "Enter Customer Id : "
            );

            String customerId =
                    scanner.next().toUpperCase();

            Customer customer =
                    CustomerManagement
                            .getCustomerMap()
                            .get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );

                return;
            }

            shipment.setCustomer(
                    customer
            );

            System.out.print(
                    "Enter Cargo Id : "
            );

            String cargoId =
                    scanner.next().toUpperCase();

            Cargo cargo =
                    CargoManagement
                            .getCargoMap()
                            .get(cargoId);

            if (cargo == null) {

                System.out.println(
                        "Cargo Not Found"
                );

                return;
            }

            shipment.setCargo(
                    cargo
            );

            System.out.print(
                    "Enter Vessel Id : "
            );

            String vesselId =
                    scanner.next().toUpperCase();

            Vessel vessel =
                    VesselManagement
                            .getVesselMap()
                            .get(vesselId);

            if (vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );

                return;
            }

            if (vessel.getVesselType()
                    .equalsIgnoreCase(
                            "PASSENGER"
                    )) {

                throw new InvalidDataException(
                        "Passenger Vessel Cannot Carry Cargo Shipments"
                );
            }

            shipment.setVessel(
                    vessel
            );

            System.out.print(
                    "Enter Schedule Id : "
            );

            String scheduleId =
                    scanner.next().toUpperCase();

            Schedule schedule =
                    ScheduleManagement
                            .getScheduleList()
                            .stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule
                                                    .getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (schedule == null) {

                System.out.println(
                        "Schedule Not Found"
                );

                return;
            }

            shipment.setSchedule(
                    schedule
            );

            shipment.setShipmentId(
                    shipmentId
            );

            shipment.setShipmentDate(
                    shipmentDate
            );

            shipment.setExpectedDeliveryDate(
                    expectedDeliveryDate
            );

            shipment.setShipmentStatus(
                    shipmentStatus
            );

            shipmentList.add(
                    shipment
            );

            System.out.println(
                    "Shipment Added Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void update() {

        int choice;

        System.out.println(
                "\n===== UPDATE SHIPMENT ====="
        );

        System.out.println(
                "1. Update Shipment Status"
        );

        System.out.println(
                "2. Update Shipment Date"
        );

        System.out.println(
                "3. Update Expected Delivery Date"
        );

        System.out.print(
                "Enter Choice : "
        );

        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                updateShipmentStatus();
                break;

            case 2:
                updateShipmentDate();
                break;

            case 3:
                updateExpectedDeliveryDate();
                break;

            default:
                System.out.println(
                        "Invalid Choice"
                );
        }
    }

    private void updateShipmentStatus() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status : SCHEDULED\n" +
                            "LOADED\n" +
                            "IN_TRANSIT\n" +
                            "ARRIVED\n" +
                            "CUSTOMS_CLEARANCE\n" +
                            "DELIVERED\n" +
                            "DELAYED"
            );

            String status =
                    scanner.nextLine().toUpperCase();

            shipment.setShipmentStatus(
                    status
            );

            System.out.println(
                    "Shipment Status Updated Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    private void updateShipmentDate() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Shipment Date : "
            );

            LocalDate shipmentDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            shipment.setShipmentDate(
                    shipmentDate
            );

            System.out.println(
                    "Shipment Date Updated Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    private void updateExpectedDeliveryDate() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Delivery Date : (yyyy-MM-dd)"
            );

            LocalDate deliveryDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );
            if (deliveryDate.isBefore(shipment.getShipmentDate())) {

                throw new InvalidDataException(
                        "Expected Delivery Date Cannot Be Before Shipment Date"
                );
            }
            shipment.setExpectedDeliveryDate(
                    deliveryDate
            );

            System.out.println(
                    "Delivery Date Updated Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void delete() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            boolean removed =
                    shipmentList.removeIf(
                            shipment ->
                                    shipment.getShipmentId()
                                            .equalsIgnoreCase(
                                                    shipmentId
                                            )
                    );

            if (removed) {

                System.out.println(
                        "Shipment Deleted Successfully"
                );
            } else {

                System.out.println(
                        "Shipment Not Found"
                );
            }

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void findById() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Optional<Shipment> shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst();

            if (shipment.isPresent()) {

                System.out.println(
                        shipment.get()
                );
            } else {

                System.out.println(
                        "Shipment Not Found"
                );
            }

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void trackShipment() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            System.out.println(
                    "Shipment Status : "
                            + shipment.getShipmentStatus()
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void assignVessel() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(
                    shipmentId
            )) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment
                                                    .getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter Vessel Id : "
            );

            String vesselId =
                    scanner.next().toUpperCase();

            Vessel vessel =
                    VesselManagement
                            .getVesselMap()
                            .get(vesselId);

            if (vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );

                return;
            }

            String vesselType =
                    vessel.getVesselType();

            if (vesselType.equalsIgnoreCase(
                    "PASSENGER"
            )) {

                throw new InvalidDataException(
                        "Passenger Vessels Cannot Be Assigned Cargo Shipments"
                );
            }

            shipment.setVessel(
                    vessel
            );

            if (shipment.getCargo() != null) {

                vessel.setCargo(
                        shipment.getCargo()
                );
            }

            System.out.println(
                    "Vessel Assigned Successfully"
            );

            System.out.println(
                    "Assigned Vessel Type : "
                            + vessel.getVesselType()
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void assignSchedule() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter Schedule Id : "
            );

            String scheduleId =
                    scanner.next().toUpperCase();

            Schedule schedule =
                    ScheduleManagement
                            .getScheduleList()
                            .stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule.getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (schedule == null) {

                System.out.println(
                        "Schedule Not Found"
                );

                return;
            }

            shipment.setSchedule(
                    schedule
            );

            System.out.println(
                    "Schedule Assigned Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void generateInvoice() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment
                                                    .getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            if (shipment.getInvoice() != null) {

                System.out.println(
                        "Invoice Already Generated"
                );

                return;
            }

            System.out.print(
                    "Enter Invoice Id : "
            );

            String invoiceId =
                    scanner.next().toUpperCase();

            System.out.print(
                    "Enter Cargo Handling Charge : "
            );

            double cargoHandlingCharge =
                    scanner.nextDouble();

            System.out.print(
                    "Enter Storage Charge : "
            );

            double storageCharge =
                    scanner.nextDouble();

            System.out.print(
                    "Enter Payment Status (PENDING / PAID) : "
            );

            String paymentStatus =
                    scanner.next().toUpperCase();

            Invoice invoice =
                    new Invoice();

            invoice.setInvoiceId(
                    invoiceId
            );

            invoice.setCargoHandlingCharge(
                    cargoHandlingCharge
            );

            invoice.setStorageCharge(
                    storageCharge
            );

            invoice.setTotalAmount(
                    cargoHandlingCharge
                            + storageCharge
            );

            invoice.setPaymentStatus(
                    paymentStatus
            );

            invoice.setCustomer(
                    shipment.getCustomer()
            );

            shipment.setInvoice(
                    invoice
            );

            System.out.println(
                    "Invoice Generated Successfully"
            );

            System.out.println(
                    invoice
            );
        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void processCustomsClearance() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            if (shipment.getCustomsClearance() != null) {

                System.out.println(
                        "Customs Clearance Already Processed"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Clearance Id : "
            );

            String clearanceId =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Clearance Status : PENDING / APPROVED / REJECTED : "
            );

            String clearanceStatus =
                    scanner.nextLine().toUpperCase();

            CustomsClearance customsClearance =
                    new CustomsClearance();

            customsClearance.setClearanceId(
                    clearanceId
            );

            customsClearance.setClearanceStatus(
                    clearanceStatus
            );

            customsClearance.setInspectionDate(
                    LocalDate.now()
            );

            customsClearance.setClearanceDate(
                    LocalDate.now()
            );

            customsClearance.setCargo(
                    shipment.getCargo()
            );

            shipment.setCustomsClearance(
                    customsClearance
            );

            System.out.println(
                    "Customs Clearance Processed Successfully"
            );

            System.out.println(
                    customsClearance
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void sendNotification() {

        System.out.print(
                "Enter Shipment Id : "
        );

        try {

            String shipmentId =
                    scanner.next().toUpperCase();

            if (!regex.validateShipmentId(shipmentId)) {

                throw new InvalidDataException(
                        "Invalid Shipment Id. Format : SHP001"
                );
            }

            Shipment shipment =
                    shipmentList.stream()
                            .filter(
                                    currentShipment ->
                                            currentShipment.getShipmentId()
                                                    .equalsIgnoreCase(
                                                            shipmentId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if (shipment == null) {

                System.out.println(
                        "Shipment Not Found"
                );

                return;
            }

            if (shipment.getNotification() != null) {

                System.out.println(
                        "Notification Already Generated"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Notification Id : "
            );

            String notificationId =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Notification Type : "
            );

            String notificationType =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Notification Message : "
            );

            String message =
                    scanner.nextLine();

            System.out.print(
                    "Enter Notification Status : "
            );

            String notificationStatus =
                    scanner.nextLine().toUpperCase();

            Notification notification =
                    new Notification();

            notification.setNotificationId(
                    notificationId
            );

            notification.setNotificationType(
                    notificationType
            );

            notification.setMessage(
                    message
            );

            notification.setNotificationDate(
                    LocalDate.now()
            );

            notification.setNotificationStatus(
                    notificationStatus
            );

            shipment.setNotification(
                    notification
            );

            System.out.println(
                    "\n===== NOTIFICATION ====="
            );

            System.out.println(
                    notification
            );

            System.out.println(
                    "Notification Sent Successfully"
            );

        } catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
     public void shipmentAnalytics() {

        int choice;

         while (true) {

            System.out.println(
                    "\n===== SHIPMENT ANALYTICS ====="
            );

            System.out.println(
                    "1. Highest Value Shipment"
            );

            System.out.println(
                    "2. Lowest Value Shipment"
            );

            System.out.println(
                    "3. Overdue Shipments"
            );

            System.out.println(
                    "4. All Shipments Billed"
            );

            System.out.println(
                    "5. Immutable Shipment List"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.print(
                    "Enter Choice : "
            );

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println(
                            "\nHighest Value Shipment"
                    );

                    shipmentList.stream()
                            .filter(
                                    shipment ->
                                            shipment.getInvoice() != null
                            )
                            .max(
                                    Comparator.comparing(
                                            shipment ->
                                                    shipment.getInvoice()
                                                            .getTotalAmount()
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 2:

                    System.out.println(
                            "\nLowest Value Shipment"
                    );

                    shipmentList.stream()
                            .filter(
                                    shipment ->
                                            shipment.getInvoice() != null
                            )
                            .min(
                                    Comparator.comparing(
                                            shipment ->
                                                    shipment.getInvoice()
                                                            .getTotalAmount()
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nOverdue Shipments"
                    );

                    shipmentList.stream()
                            .filter(
                                    shipment ->
                                            shipment.getExpectedDeliveryDate()
                                                    .isBefore(
                                                            LocalDate.now()
                                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 4:

                    boolean allBilled =
                            shipmentList.stream()
                                    .allMatch(
                                            shipment ->
                                                    shipment.getInvoice()
                                                            != null
                                    );

                    System.out.println(
                            "\nAll Shipments Billed : "
                                    + allBilled
                    );

                    break;

                case 5:

                    List<Shipment> immutableList =
                            shipmentList.stream()
                                    .toList();

                    System.out.println(
                            "\nImmutable Shipment List Size : "
                                    + immutableList.size()
                    );

                    immutableList.forEach(
                            System.out::println
                    );

                    break;

                case 0:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        }
    }
}