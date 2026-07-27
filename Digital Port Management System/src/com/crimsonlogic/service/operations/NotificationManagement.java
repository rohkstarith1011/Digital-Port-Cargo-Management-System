package com.crimsonlogic.service.operations;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.compositionclasses.administration.Notification;
import com.crimsonlogic.service.interfaces.StatusManageable;
import com.crimsonlogic.utility.ValidationClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NotificationManagement implements StatusManageable {
    ValidationClass regex = new ValidationClass();

    private static ArrayList<Notification>
            notificationList =
            new ArrayList<>();

    Scanner scanner =
            new Scanner(System.in);


    @Override
    public void updateStatus() {

        System.out.print(
                "Enter Notification Id : "
        );

        try {

            String notificationId =
                    scanner.next().toUpperCase();

            if(!regex.validateNotificationId(
                    notificationId
            )) {

                throw new InvalidDataException(
                        "Invalid Notification Id. Format : NOT001"
                );
            }

            Notification notification =
                    notificationList.stream()
                            .filter(
                                    currentNotification ->
                                            currentNotification
                                                    .getNotificationId()
                                                    .equalsIgnoreCase(
                                                            notificationId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(notification == null) {

                System.out.println(
                        "Notification Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status :PENDING\n" +
                            "SENT\n" +
                            "READ "
            );

            String status =
                    scanner.nextLine().toUpperCase();

            notification.setNotificationStatus(
                    status
            );

            System.out.println(
                    "Notification Status Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void createNotification() {

        try {

            System.out.print(
                    "Enter Notification Id : "
            );

            String notificationId =
                    scanner.next().toUpperCase();

            if(!regex.validateNotificationId(
                    notificationId
            )) {

                throw new InvalidDataException(
                        "Invalid Notification Id. Format : NOT001"
                );
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Notification Type : SHIPMENT UPDATE\n" +
                            "CUSTOMS ALERT\n" +
                            "INVOICE GENERATED\n" +
                            "CARGO STATUS UPDATE"
            );

            String notificationType =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Notification Message : "
            );

            String message =
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
                    "PENDING"
            );

            notificationList.add(
                    notification
            );

            System.out.println(
                    "Notification Created Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void sendNotification() {

        System.out.print(
                "Enter Notification Id : "
        );

        try {

            String notificationId =
                    scanner.next().toUpperCase();

            if(!regex.validateNotificationId(
                    notificationId
            )) {

                throw new InvalidDataException(
                        "Invalid Notification Id. Format : NOT001"
                );
            }

            Notification notification =
                    notificationList.stream()
                            .filter(
                                    currentNotification ->
                                            currentNotification
                                                    .getNotificationId()
                                                    .equalsIgnoreCase(
                                                            notificationId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(notification == null) {

                System.out.println(
                        "Notification Not Found"
                );

                return;
            }

            notification.setNotificationStatus(
                    "SENT"
            );

            System.out.println(
                    "\n===== NOTIFICATION ====="
            );

            System.out.println(
                    notification
            );

            System.out.println(
                    "\nNotification Sent Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void findNotificationById() {

        System.out.print(
                "Enter Notification Id : "
        );

        try {

            String notificationId =
                    scanner.next().toUpperCase();

            if(!regex.validateNotificationId(
                    notificationId
            )) {

                throw new InvalidDataException(
                        "Invalid Notification Id. Format : NOT001"
                );
            }

            Optional<Notification> notification =
                    notificationList.stream()
                            .filter(
                                    currentNotification ->
                                            currentNotification
                                                    .getNotificationId()
                                                    .equalsIgnoreCase(
                                                            notificationId
                                                    )
                            )
                            .findFirst();

            if(notification.isPresent()) {

                System.out.println(
                        notification.get()
                );
            }
            else {

                System.out.println(
                        "Notification Not Found"
                );
            }

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void viewAllNotifications() {

        notificationList.forEach(
                System.out::println
        );
    }
    public void viewUnreadNotifications() {

        notificationList.stream()
                .filter(
                        notification ->
                                notification
                                        .getNotificationStatus()
                                        .equalsIgnoreCase(
                                                "PENDING"
                                        )
                )
                .forEach(
                        System.out::println
                );
    }
    public void notificationAnalytics() {

        int choice;

        while(true){

            System.out.println(
                    "\n===== NOTIFICATION ANALYTICS ====="
            );

            System.out.println(
                    "1. Total Notifications"
            );

            System.out.println(
                    "2. Notification Status Count"
            );

            System.out.println(
                    "3. Notification Type Count"
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
                            "\nTotal Notifications : "
                                    + notificationList.size()
                    );

                    break;

                case 2:

                    System.out.println(
                            "\nNotification Status Count"
                    );

                    notificationList.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            Notification::getNotificationStatus,
                                            Collectors.counting()
                                    )
                            )
                            .forEach(
                                    (status, count) ->
                                            System.out.println(
                                                    status
                                                            + " : "
                                                            + count
                                            )
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nNotification Type Count"
                    );

                    notificationList.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            Notification::getNotificationType,
                                            Collectors.counting()
                                    )
                            )
                            .forEach(
                                    (type, count) ->
                                            System.out.println(
                                                    type
                                                            + " : "
                                                            + count
                                            )
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
