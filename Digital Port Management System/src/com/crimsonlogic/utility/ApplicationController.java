package com.crimsonlogic.utility;

import com.crimsonlogic.service.management.*;
import com.crimsonlogic.service.operations.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationController {

    // Service Objects

    private CargoManagement cargoManagement=new CargoManagement();

    private VesselManagement vesselManagement=new VesselManagement();

    private BerthManagement berthManagement=new BerthManagement();

    private ScheduleManagement scheduleManagement=new ScheduleManagement();

    private ContainerManagement containerManagement=new ContainerManagement();

    private ShipmentManagement shipmentManagement=new ShipmentManagement();

    private CustomerManagement customerManagement=new CustomerManagement();

    private CustomsManagement customsManagement=new CustomsManagement();

    private NotificationManagement notificationManagement=new NotificationManagement();

    private ReportManagement reportManagement=new ReportManagement();

    // Scanner

    private Scanner scanner=new Scanner(System.in);

    // Constructor

    public ApplicationController() {

    }

    // ==========================
    // 1. Cargo Management
    // ==========================

    public void cargoOperations() {

        while(true) {

            int choice;

            try{
                System.out.println(
                        "\n===== CARGO MANAGEMENT ====="
                );

                System.out.println(
                        "1. Add Cargo"
                );

                System.out.println(
                        "2. Update Cargo"
                );

                System.out.println(
                        "3. Delete Cargo"
                );

                System.out.println(
                        "4. Search Cargo By Id"
                );

                System.out.println(
                        "5. Track Cargo Status"
                );

                System.out.println(
                        "6. Search Cargo By Customer"
                );

                System.out.println(
                        "7. Search Cargo By Vessel"
                );

                System.out.println(
                        "8. Optional Cargo Lookup"
                );

                System.out.println(
                        "9. Cargo Analytics"
                );

                System.out.println(
                        "0. Back"
                );

                System.out.print(
                        "Enter Choice : "
                );

                choice = scanner.nextInt();

                switch(choice) {

                    case 1:
                        cargoManagement.add();
                        break;

                    case 2:
                        cargoManagement.update();
                        break;

                    case 3:
                        cargoManagement.delete();
                        break;

                    case 4:
                        cargoManagement.findById();
                        break;

                    case 5:
                        cargoManagement.trackCargoStatus();
                        break;

                    case 6:
                        cargoManagement.searchCargoByCustomer();
                        break;

                    case 7:
                        cargoManagement.searchCargoByVessel();
                        break;

                    case 8:
                        cargoManagement.optionalCargoLookup();
                        break;

                    case 9:
                        cargoManagement.cargoAnalytics();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println(
                                "Invalid Choice"
                        );
                }
                }catch(InputMismatchException ex){
                System.out.println("Invalid input! try again");
            }
            }

    }

    // ==========================
    // 2. Vessel Management
    // ==========================

    public void vesselOperations() {

        int choice;

        while(true) {
            try{
            System.out.println(
                    "\n===== VESSEL MANAGEMENT ====="
            );

            System.out.println(
                    "1. Register Vessel"
            );

            System.out.println(
                    "2. Update Vessel"
            );

            System.out.println(
                    "3. Delete Vessel"
            );

            System.out.println(
                    "4. Search Vessel"
            );

            System.out.println(
                    "5. View Active Vessels"
            );

            System.out.println(
                    "6. Find Delayed Vessels"
            );

            System.out.println(
                    "7. Vessel Analytics"
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
                    vesselManagement.add();
                    break;

                case 2:
                    vesselManagement.update();
                    break;

                case 3:
                    vesselManagement.delete();
                    break;

                case 4:
                    vesselManagement.findById();
                    break;

                case 5:
                    vesselManagement.viewActiveVessels();
                    break;

                case 6:
                    vesselManagement.findDelayedVessels();
                    break;

                case 7:
                    vesselManagement.vesselAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch(InputMismatchException ex){
            System.out.println("Invalid input! try again");
        }
        }
    }

    // ==========================
    // 3. Berth Management
    // ==========================

    public void berthOperations() {

        int choice;

        while (true){
         try {
             System.out.println(
                     "\n===== BERTH MANAGEMENT ====="
             );

             System.out.println(
                     "1. Allocate Berth"
             );

             System.out.println(
                     "2. Reallocate Berth"
             );

             System.out.println(
                     "3. Release Berth"
             );

             System.out.println(
                     "4. Find Berth By Id"
             );

             System.out.println(
                     "5. Update Berth Status"
             );

             System.out.println(
                     "6. Berth Analytics"
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
                     berthManagement.allocateBerth();
                     break;

                 case 2:
                     berthManagement.reallocateBerth();
                     break;

                 case 3:
                     berthManagement.releaseBerth();
                     break;

                 case 4:
                     berthManagement.findBerthById();
                     break;

                 case 5:
                     berthManagement.updateStatus();
                     break;

                 case 6:
                     berthManagement.berthAnalytics();
                     break;

                 case 0:
                     return;

                 default:
                     System.out.println(
                             "Invalid Choice"
                     );
             }
         }catch (InputMismatchException ex){
             System.out.println("Invalid input please try again");
             continue;
         }
        }
    }

    // ==========================
    // 4. Port Scheduling
    // ==========================

    public void scheduleOperations() {

        int choice;

        while(true){
        try {
            System.out.println(
                    "\n===== PORT SCHEDULING ====="
            );

            System.out.println(
                    "1. Create Schedule"
            );

            System.out.println(
                    "2. Schedule Arrival"
            );

            System.out.println(
                    "3. Schedule Departure"
            );

            System.out.println(
                    "4. Find Schedule By Id"
            );

            System.out.println(
                    "5. Update Schedule Status"
            );

            System.out.println(
                    "6. Check Schedule Conflict"
            );

            System.out.println(
                    "7. Adjust Schedule By Weather"
            );

            System.out.println(
                    "8. Schedule Analytics"
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
                    scheduleManagement.createSchedule();
                    break;

                case 2:
                    scheduleManagement.scheduleArrival();
                    break;

                case 3:
                    scheduleManagement.scheduleDeparture();
                    break;

                case 4:
                    scheduleManagement.findScheduleById();
                    break;

                case 5:
                    scheduleManagement.updateStatus();
                    break;

                case 6:
                    scheduleManagement.checkScheduleConflict();
                    break;

                case 7:
                    scheduleManagement.adjustScheduleByWeather();
                    break;

                case 8:
                    scheduleManagement.scheduleAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 5. Container Management
    // ==========================

    public void containerOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== CONTAINER MANAGEMENT ====="
            );

            System.out.println(
                    "1. Add Container"
            );

            System.out.println(
                    "2. Update Container"
            );

            System.out.println(
                    "3. Delete Container"
            );

            System.out.println(
                    "4. Search Container"
            );

            System.out.println(
                    "5. Search Container By Type"
            );

            System.out.println(
                    "6. Container Analytics"
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
                    containerManagement.add();
                    break;

                case 2:
                    containerManagement.update();
                    break;

                case 3:
                    containerManagement.delete();
                    break;

                case 4:
                    containerManagement.findById();
                    break;

                case 5:
                    containerManagement.searchContainerByType();
                    break;

                case 6:
                    containerManagement.containerAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 6. Yard Management
    // Redirect To Container
    // ==========================

    public void yardOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== YARD MANAGEMENT ====="
            );

            System.out.println(
                    "1. Assign Container To Yard"
            );

            System.out.println(
                    "2. Remove Container From Yard"
            );

            System.out.println(
                    "3. View Available Containers"
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
                    containerManagement.assignContainerToYard();
                    break;

                case 2:
                    containerManagement.removeContainerFromYard();
                    break;

                case 3:
                    containerManagement.viewAvailableContainers();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 7. Shipment Management
    // ==========================

    public void shipmentOperations() {


            int choice;

            while (true){
            try {
                System.out.println(
                        "\n===== SHIPMENT MANAGEMENT ====="
                );

                System.out.println(
                        "1. Add Shipment"
                );

                System.out.println(
                        "2. Update Shipment"
                );

                System.out.println(
                        "3. Delete Shipment"
                );

                System.out.println(
                        "4. Search Shipment"
                );

                System.out.println(
                        "5. Track Shipment"
                );

                System.out.println(
                        "6. Assign Vessel"
                );

                System.out.println(
                        "7. Assign Schedule"
                );

                System.out.println(
                        "8. Process Customs Clearance"
                );

                System.out.println(
                        "9. Send Notification"
                );

                System.out.println(
                        "10. Shipment Analytics"
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
                        shipmentManagement.add();
                        break;

                    case 2:
                        shipmentManagement.update();
                        break;

                    case 3:
                        shipmentManagement.delete();
                        break;

                    case 4:
                        shipmentManagement.findById();
                        break;

                    case 5:
                        shipmentManagement.trackShipment();
                        break;

                    case 6:
                        shipmentManagement.assignVessel();
                        break;

                    case 7:
                        shipmentManagement.assignSchedule();
                        break;

                    case 8:
                        shipmentManagement.processCustomsClearance();
                        break;

                    case 9:
                        shipmentManagement.sendNotification();
                        break;

                    case 10:
                        shipmentManagement.shipmentAnalytics();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println(
                                "Invalid Choice"
                        );
                }
            }catch (InputMismatchException ex){
                System.out.println("Invalid input please try again");
                continue;
            }
            }

    }

    // ==========================
    // 8. Customer Management
    // ==========================

    public void customerOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== CUSTOMER MANAGEMENT ====="
            );

            System.out.println(
                    "1. Add Customer"
            );

            System.out.println(
                    "2. Update Customer"
            );

            System.out.println(
                    "3. Delete Customer"
            );

            System.out.println(
                    "4. Search Customer"
            );

            System.out.println(
                    "5. Display All Customers"
            );

            System.out.println(
                    "6. Customer Analytics"
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
                    customerManagement.add();
                    break;

                case 2:
                    customerManagement.update();
                    break;

                case 3:
                    customerManagement.delete();
                    break;

                case 4:
                    customerManagement.findById();
                    break;

                case 5:
                    customerManagement.displayAllCustomers();
                    break;

                case 6:
                    customerManagement.customerAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 9. Billing & Invoicing
    // ==========================

    public void billingOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== BILLING & INVOICING ====="
            );

            System.out.println(
                    "1. Generate Invoice"
            );

            System.out.println(
                    "2. Revenue Analytics"
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
                    shipmentManagement.generateInvoice();
                    break;

                case 2:
                    reportManagement.revenueAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 10. Customs Clearance
    // ==========================

    public void customsOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== CUSTOMS CLEARANCE ====="
            );

            System.out.println(
                    "1. Approve Clearance"
            );

            System.out.println(
                    "2. Reject Clearance"
            );

            System.out.println(
                    "3. Find Clearance"
            );

            System.out.println(
                    "4. View Pending Clearances"
            );

            System.out.println(
                    "5. View Approved Clearances"
            );

            System.out.println(
                    "6. Validate Hazardous Cargo"
            );

            System.out.println(
                    "7. Customs Analytics"
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
                    customsManagement.approveClearance();
                    break;

                case 2:
                    customsManagement.rejectClearance();
                    break;

                case 3:
                    customsManagement.findClearanceById();
                    break;

                case 4:
                    customsManagement.viewPendingClearances();
                    break;

                case 5:
                    customsManagement.viewApprovedClearances();
                    break;

                case 6:
                    customsManagement.validateHazardousCargo();
                    break;

                case 7:
                    customsManagement.customsAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 11. Notification Service
    // ==========================

    public void notificationOperations() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== NOTIFICATION SERVICE ====="
            );

            System.out.println(
                    "1. Create Notification"
            );

            System.out.println(
                    "2. Send Notification"
            );

            System.out.println(
                    "3. Find Notification"
            );

            System.out.println(
                    "4. View All Notifications"
            );

            System.out.println(
                    "5. View Unread Notifications"
            );

            System.out.println(
                    "6. Update Notification Status"
            );
            System.out.println(
                    "7. Notification Analytics"
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
                    notificationManagement.createNotification();
                    break;

                case 2:
                    notificationManagement.sendNotification();
                    break;

                case 3:
                    notificationManagement.findNotificationById();
                    break;

                case 4:
                    notificationManagement.viewAllNotifications();
                    break;

                case 5:
                    notificationManagement.viewUnreadNotifications();
                    break;

                case 6:
                    notificationManagement.updateStatus();
                    break;

                case 7:
                    notificationManagement.notificationAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 12. Reports & Analytics
    // ==========================

    public void dashboardReports() {

        int choice;

        while (true){
        try {
            System.out.println(
                    "\n===== REPORTS & ANALYTICS ====="
            );

            System.out.println(
                    "1. Cargo Analytics"
            );

            System.out.println(
                    "2. Vessel Analytics"
            );

            System.out.println(
                    "3. Berth Analytics"
            );

            System.out.println(
                    "4. Shipment Analytics"
            );

            System.out.println(
                    "5. Revenue Analytics"
            );

            System.out.println(
                    "6. Customs Analytics"
            );

            System.out.println(
                    "7. Cargo Manifest"
            );

            System.out.println(
                    "8. Stream Performance Analytics"
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
                    reportManagement.cargoAnalytics();
                    break;

                case 2:
                    reportManagement.vesselAnalytics();
                    break;

                case 3:
                    reportManagement.berthAnalytics();
                    break;

                case 4:
                    reportManagement.shipmentAnalytics();
                    break;

                case 5:
                    reportManagement.revenueAnalytics();
                    break;

                case 6:
                    reportManagement.customsAnalytics();
                    break;

                case 7:
                    reportManagement.manifestAnalytics();
                    break;

                case 8:
                    reportManagement.streamPerformanceAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

    // ==========================
    // 13. Admin Module
    // ==========================

    public void adminOperations() {

        int choice;

        while (true) {
        try{
            System.out.println(
                    "\n===== ADMIN MODULE ====="
            );

            System.out.println(
                    "1. Display All Customers"
            );

            System.out.println(
                    "2. View All Notifications"
            );

            System.out.println(
                    "3. Cargo Analytics"
            );

            System.out.println(
                    "4. Stream Performance Analytics"
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
                    customerManagement.displayAllCustomers();
                    break;

                case 2:
                    notificationManagement.viewAllNotifications();
                    break;

                case 3:
                    cargoManagement.cargoAnalytics();
                    break;

                case 4:
                    reportManagement.streamPerformanceAnalytics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }catch (InputMismatchException ex){
            System.out.println("Invalid input please try again");
            continue;
        }
        }
    }

}