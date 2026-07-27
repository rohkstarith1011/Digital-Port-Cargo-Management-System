package com.crimsonlogic.utility;

import java.util.Scanner;

public class MenuDrivenApplication {

    private Scanner scanner =
            new Scanner(System.in);

    private ApplicationController controller =
            new ApplicationController();

    public void start() {

        String command;

        while(true){

            System.out.println(
                    "\n=================================================="
            );

            System.out.println(
                    "      DIGITAL PORT CARGO MANAGEMENT SYSTEM"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "cargo        -> Cargo Management"
            );

            System.out.println(
                    "vessel       -> Vessel Management"
            );

            System.out.println(
                    "berth        -> Berth Management"
            );

            System.out.println(
                    "schedule     -> Port Scheduling"
            );

            System.out.println(
                    "container    -> Container Management"
            );

            System.out.println(
                    "yard         -> Yard Management"
            );

            System.out.println(
                    "shipment     -> Shipment Management"
            );

            System.out.println(
                    "customer     -> Customer Management"
            );

            System.out.println(
                    "billing      -> Billing & Invoicing"
            );

            System.out.println(
                    "customs      -> Customs Clearance"
            );

            System.out.println(
                    "notification -> Notification Service"
            );

            System.out.println(
                    "reports      -> Reports & Analytics"
            );

            System.out.println(
                    "admin        -> Admin Module"
            );

            System.out.println(
                    "exit         -> Close Application"
            );

            System.out.print(
                    "\nEnter Command : "
            );

            command =
                    scanner.nextLine();

            switch(command.toLowerCase()) {

                case "cargo":
                    controller.cargoOperations();
                    break;

                case "vessel":
                    controller.vesselOperations();
                    break;

                case "berth":
                    controller.berthOperations();
                    break;

                case "schedule":
                    controller.scheduleOperations();
                    break;

                case "container":
                    controller.containerOperations();
                    break;

                case "yard":
                    controller.yardOperations();
                    break;

                case "shipment":
                    controller.shipmentOperations();
                    break;

                case "customer":
                    controller.customerOperations();
                    break;

                case "billing":
                    controller.billingOperations();
                    break;

                case "customs":
                    controller.customsOperations();
                    break;

                case "notification":
                    controller.notificationOperations();
                    break;

                case "reports":
                    controller.dashboardReports();
                    break;

                case "admin":
                    controller.adminOperations();
                    break;

                case "exit":

                    System.out.println(
                            "\nApplication Closed Successfully..."
                    );

                    return;

                default:

                    System.out.println(
                            "\nInvalid Command!"
                    );
            }

        }
    }
}