package com.crimsonlogic.service.operations;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.implementationclasses.portfacility.Berth;
import com.crimsonlogic.service.interfaces.StatusManageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

public class BerthManagement implements StatusManageable {
    ValidationClass regex = new ValidationClass();

    private static TreeSet<Berth> berthSet =
            new TreeSet<>(
                    Comparator.comparing(
                            Berth::getFacilityId
                    )
            );
    static {

        Berth berth1 = new Berth();
        berth1.setFacilityId("BER001");
        berth1.setFacilityName("Container Berth");
        berth1.setFacilityLocation("Zone A");
        berth1.setFacilityStatus("AVAILABLE");
        berth1.setBerthType("CONTAINER");
        berth1.setBerthCapacity(5000);
        berth1.setOccupied(false);

        Berth berth2 = new Berth();
        berth2.setFacilityId("BER002");
        berth2.setFacilityName("RORO Berth");
        berth2.setFacilityLocation("Zone B");
        berth2.setFacilityStatus("AVAILABLE");
        berth2.setBerthType("RORO");
        berth2.setBerthCapacity(4000);
        berth2.setOccupied(false);

        Berth berth3 = new Berth();
        berth3.setFacilityId("BER003");
        berth3.setFacilityName("Passenger Berth");
        berth3.setFacilityLocation("Zone C");
        berth3.setFacilityStatus("AVAILABLE");
        berth3.setBerthType("PASSENGER");
        berth3.setBerthCapacity(3000);
        berth3.setOccupied(false);

        berthSet.add(berth1);
        berthSet.add(berth2);
        berthSet.add(berth3);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void updateStatus() {

        System.out.print("Enter Berth Id : ");

        try {

            String berthId = scanner.next().toUpperCase();

            if (!regex.validateBerthId(berthId)) {

                throw new InvalidDataException(
                        "Invalid Berth Id. Format : BER001"
                );
            }

            Berth berth =
                    berthSet.stream()
                            .filter(
                                    currentBerth ->
                                            currentBerth.getFacilityId()
                                                    .equalsIgnoreCase(berthId)
                            )
                            .findFirst()
                            .orElse(null);

            if (berth == null) {

                System.out.println(
                        "Berth Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status : AVAILABLE\n" +
                            "OCCUPIED\n" +
                            "RESERVED"
            );

            String status =
                    scanner.nextLine().toUpperCase();

            berth.setFacilityStatus(status);

            System.out.println(
                    "Status Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void allocateBerth() {

        System.out.print(
                "Enter Berth Id : "
        );

        try {

            String berthId =
                    scanner.next().toUpperCase();

            if (!regex.validateBerthId(berthId)) {

                throw new InvalidDataException(
                        "Invalid Berth Id. Format : BER001"
                );
            }

            Berth berth =
                    berthSet.stream()
                            .filter(
                                    currentBerth ->
                                            currentBerth.getFacilityId()
                                                    .equalsIgnoreCase(berthId)
                            )
                            .findFirst()
                            .orElse(null);

            if (berth == null) {

                System.out.println(
                        "Berth Not Found"
                );

                return;
            }

            if (berth.isOccupied()) {

                System.out.println(
                        "Berth Already Occupied"
                );

                return;
            }

            berth.setOccupied(true);
            berth.setFacilityStatus("OCCUPIED");

            System.out.println(
                    "Berth Allocated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void reallocateBerth() {

        System.out.print(
                "Enter Berth Id : "
        );

        try {

            String berthId =
                    scanner.next().toUpperCase();

            if (!regex.validateBerthId(berthId)) {

                throw new InvalidDataException(
                        "Invalid Berth Id. Format : BER001"
                );
            }

            Berth berth =
                    berthSet.stream()
                            .filter(
                                    currentBerth ->
                                            currentBerth.getFacilityId()
                                                    .equalsIgnoreCase(berthId)
                            )
                            .findFirst()
                            .orElse(null);

            if (berth == null) {

                System.out.println(
                        "Berth Not Found"
                );

                return;
            }

            berth.setOccupied(false);

            System.out.println(
                    "Previous Allocation Released"
            );

            berth.setOccupied(true);
            berth.setFacilityStatus("OCCUPIED");

            System.out.println(
                    "Berth Reallocated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void releaseBerth() {

        System.out.print(
                "Enter Berth Id : "
        );

        try {

            String berthId =
                    scanner.next().toUpperCase();

            if (!regex.validateBerthId(berthId)) {

                throw new InvalidDataException(
                        "Invalid Berth Id. Format : BER001"
                );
            }

            Berth berth =
                    berthSet.stream()
                            .filter(
                                    currentBerth ->
                                            currentBerth.getFacilityId()
                                                    .equalsIgnoreCase(berthId)
                            )
                            .findFirst()
                            .orElse(null);

            if (berth == null) {

                System.out.println(
                        "Berth Not Found"
                );

                return;
            }

            berth.setOccupied(false);
            berth.setFacilityStatus("AVAILABLE");

            System.out.println(
                    "Berth Released Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void findBerthById() {

        System.out.print(
                "Enter Berth Id : "
        );

        try {

            String berthId =
                    scanner.next().toUpperCase();

            if (!regex.validateBerthId(berthId)) {

                throw new InvalidDataException(
                        "Invalid Berth Id. Format : BER001"
                );
            }

            Optional<Berth> berth =
                    berthSet.stream()
                            .filter(
                                    currentBerth ->
                                            currentBerth.getFacilityId()
                                                    .equalsIgnoreCase(berthId)
                            )
                            .findFirst();

            if (berth.isPresent()) {

                System.out.println(
                        berth.get()
                );

            }
            else {

                System.out.println(
                        "Berth Not Found"
                );
            }

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    public void berthAnalytics() {

        int choice;

        do {

            System.out.println(
                    "\n===== BERTH ANALYTICS ====="
            );

            System.out.println(
                    "1. List Available Berths"
            );

            System.out.println(
                    "2. Most Utilized Berth"
            );

            System.out.println(
                    "3. Least Utilized Berth"
            );

            System.out.println(
                    "4. Any Berth Available"
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

                    berthSet.stream()
                            .filter(
                                    berth ->
                                            !berth.isOccupied()
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 2:

                    berthSet.stream()
                            .max(
                                    Comparator.comparing(
                                            Berth::getBerthCapacity
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 3:

                    berthSet.stream()
                            .min(
                                    Comparator.comparing(
                                            Berth::getBerthCapacity
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 4:

                    boolean available =
                            berthSet.stream()
                                    .anyMatch(
                                            berth ->
                                                    !berth.isOccupied()
                                    );

                    System.out.println(
                            "Available : "
                                    + available
                    );

                    break;

                case 0:
                    return;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while (choice != 0);
    }
}
