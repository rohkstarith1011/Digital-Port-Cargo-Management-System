package com.crimsonlogic.service.operations;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.compositionclasses.administration.CustomsClearance;
import com.crimsonlogic.service.interfaces.StatusManageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.*;
import java.util.stream.Collectors;

public class CustomsManagement implements StatusManageable {
    ValidationClass regex = new ValidationClass();

    private static ArrayList<CustomsClearance>
            customsClearanceList =
            new ArrayList<>();

    Scanner scanner =
            new Scanner(System.in);

    @Override
    public void updateStatus() {

        System.out.print(
                "Enter Clearance Id : "
        );

        try {

            String clearanceId =
                    scanner.next().toUpperCase();

            if(!regex.validateClearanceId(clearanceId)) {

                throw new InvalidDataException(
                        "Invalid Clearance Id. Format : CLR001"
                );
            }

            CustomsClearance clearance =
                    customsClearanceList.stream()
                            .filter(
                                    currentClearance ->
                                            currentClearance.getClearanceId()
                                                    .equalsIgnoreCase(
                                                            clearanceId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(clearance == null) {

                System.out.println(
                        "Clearance Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status : "
            );

            String status =
                    scanner.nextLine().toUpperCase();

            clearance.setClearanceStatus(
                    status
            );

            System.out.println(
                    "Status Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void approveClearance() {

        System.out.print(
                "Enter Clearance Id : "
        );

        try {

            String clearanceId =
                    scanner.next().toUpperCase();

            if(!regex.validateClearanceId(clearanceId)) {

                throw new InvalidDataException(
                        "Invalid Clearance Id. Format : CLR001"
                );
            }

            CustomsClearance clearance =
                    customsClearanceList.stream()
                            .filter(
                                    currentClearance ->
                                            currentClearance.getClearanceId()
                                                    .equalsIgnoreCase(
                                                            clearanceId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(clearance == null) {

                System.out.println(
                        "Clearance Not Found"
                );

                return;
            }

            clearance.setClearanceStatus(
                    "APPROVED"
            );

            System.out.println(
                    "Customs Clearance Approved"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void rejectClearance() {

        System.out.print(
                "Enter Clearance Id : "
        );

        try {

            String clearanceId =
                    scanner.next().toUpperCase();

            if(!regex.validateClearanceId(clearanceId)) {

                throw new InvalidDataException(
                        "Invalid Clearance Id. Format : CLR001"
                );
            }

            CustomsClearance clearance =
                    customsClearanceList.stream()
                            .filter(
                                    currentClearance ->
                                            currentClearance.getClearanceId()
                                                    .equalsIgnoreCase(
                                                            clearanceId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(clearance == null) {

                System.out.println(
                        "Clearance Not Found"
                );

                return;
            }

            clearance.setClearanceStatus(
                    "REJECTED"
            );

            System.out.println(
                    "Customs Clearance Rejected"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void findClearanceById() {

        System.out.print(
                "Enter Clearance Id : "
        );

        try {

            String clearanceId =
                    scanner.next().toUpperCase();

            if(!regex.validateClearanceId(clearanceId)) {

                throw new InvalidDataException(
                        "Invalid Clearance Id. Format : CLR001"
                );
            }

            Optional<CustomsClearance> clearance =
                    customsClearanceList.stream()
                            .filter(
                                    currentClearance ->
                                            currentClearance.getClearanceId()
                                                    .equalsIgnoreCase(
                                                            clearanceId
                                                    )
                            )
                            .findFirst();

            if(clearance.isPresent()) {

                System.out.println(
                        clearance.get()
                );
            }
            else {

                System.out.println(
                        "Clearance Not Found"
                );
            }

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void viewPendingClearances() {

        customsClearanceList.stream()
                .filter(
                        clearance ->
                                clearance.getClearanceStatus()
                                        .equalsIgnoreCase(
                                                "PENDING"
                                        )
                )
                .forEach(
                        System.out::println
                );
    }
    public void viewApprovedClearances() {

        customsClearanceList.stream()
                .filter(
                        clearance ->
                                clearance.getClearanceStatus()
                                        .equalsIgnoreCase(
                                                "APPROVED"
                                        )
                )
                .forEach(
                        System.out::println
                );
    }

    //advance requirement
    public void validateHazardousCargo() {

        customsClearanceList.stream()
                .filter(
                        clearance ->
                                clearance.getCargo() != null
                                        &&
                                        clearance.getCargo()
                                                .isHazardous()
                )
                .forEach(
                        System.out::println
                );
    }
    public void customsAnalytics() {

        int choice;

        do {

            System.out.println(
                    "\n===== CUSTOMS ANALYTICS ====="
            );

            System.out.println(
                    "1. Approved Clearances"
            );

            System.out.println(
                    "2. Pending / Rejected Clearances"
            );

            System.out.println(
                    "3. View Partition Summary"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.print(
                    "Enter Choice : "
            );

            choice = scanner.nextInt();

            Map<Boolean, List<CustomsClearance>>
                    clearancePartition =

                    customsClearanceList.stream()
                            .collect(
                                    Collectors.partitioningBy(
                                            clearance ->
                                                    clearance
                                                            .getClearanceStatus()
                                                            .equalsIgnoreCase(
                                                                    "APPROVED"
                                                            )
                                    )
                            );

            switch (choice) {

                case 1:

                    System.out.println(
                            "\nApproved Clearances"
                    );

                    clearancePartition.get(true)
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 2:

                    System.out.println(
                            "\nPending / Rejected Clearances"
                    );

                    clearancePartition.get(false)
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nPartition Summary"
                    );

                    System.out.println(
                            "Approved : "
                                    + clearancePartition
                                    .get(true)
                                    .size()
                    );

                    System.out.println(
                            "Pending / Rejected : "
                                    + clearancePartition
                                    .get(false)
                                    .size()
                    );

                    break;

                case 0:

                    break;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while (choice != 0);
    }


}

