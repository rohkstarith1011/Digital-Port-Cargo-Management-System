package com.crimsonlogic.service.management;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.implementationclasses.transportasset.Vessel;
import com.crimsonlogic.service.interfaces.Manageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class VesselManagement implements Manageable {

    ValidationClass regex = new ValidationClass();

    private static HashMap<String, Vessel> vesselMap =
            new HashMap<>();

    private static PriorityQueue<Vessel> vesselQueue =
            new PriorityQueue<>(
                    Comparator.comparing(
                            Vessel::getVesselCapacity
                    ).reversed()
            );

    Scanner scanner =
            new Scanner(System.in);


    static {

        Vessel vessel1 = new Vessel();
        vessel1.setAssetId("VES001");
        vessel1.setAssetName("PRINCESS");
        vessel1.setAssetStatus("ACTIVE");
        vessel1.setVesselType("CONTAINER");
        vessel1.setVesselFlag("INDIA");
        vessel1.setVesselCapacity(100000);

        Vessel vessel2 = new Vessel();
        vessel2.setAssetId("VES002");
        vessel2.setAssetName("SEA RIDER");
        vessel2.setAssetStatus("ACTIVE");
        vessel2.setVesselType("RORO");
        vessel2.setVesselFlag("SINGAPORE");
        vessel2.setVesselCapacity(80000);

        Vessel vessel3 = new Vessel();
        vessel3.setAssetId("VES003");
        vessel3.setAssetName("OCEAN STAR");
        vessel3.setAssetStatus("INACTIVE");
        vessel3.setVesselType("PASSENGER");
        vessel3.setVesselFlag("MALAYSIA");
        vessel3.setVesselCapacity(120000);

        Vessel vessel4 = new Vessel();
        vessel4.setAssetId("VES004");
        vessel4.setAssetName("BLACK PEARL");
        vessel4.setAssetStatus("DELAYED");
        vessel4.setVesselType("CONTAINER");
        vessel4.setVesselFlag("INDIA");
        vessel4.setVesselCapacity(90000);

        Vessel vessel5 = new Vessel();
        vessel5.setAssetId("VES005");
        vessel5.setAssetName("SEA QUEEN");
        vessel5.setAssetStatus("ACTIVE");
        vessel5.setVesselType("RORO");
        vessel5.setVesselFlag("UAE");
        vessel5.setVesselCapacity(110000);

        vesselMap.put("VES001", vessel1);
        vesselMap.put("VES002", vessel2);
        vesselMap.put("VES003", vessel3);
        vesselMap.put("VES004", vessel4);
        vesselMap.put("VES005", vessel5);
    }

    @Override
    public void add() {

        try {

            System.out.print(
                    "Enter Vessel Id : "
            );

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            if(vesselMap.containsKey(vesselId)) {

                System.out.println(
                        "Vessel Already Exists"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Vessel Name : "
            );

            String vesselName =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Vessel Type : CONTAINER\n" +
                            "PASSENGER\n" +
                            "RORO"
            );
            String vesselType =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Vessel Capacity : "
            );

            double vesselCapacity =
                    scanner.nextDouble();

            scanner.nextLine();

            System.out.print(
                    "Enter Vessel Status : ACTIVE\n" +
                            "INACTIVE\n" +
                            "DOCKED\n" +
                            "SAILING\n" +
                            "UNDER_MAINTENANCE\n" +
                            "DELAYED"
            );

            String vesselStatus =
                    scanner.nextLine().toUpperCase();
            System.out.print(
                    "Enter Vessel Flag : "
            );
            String vesselFlag=scanner.next().toUpperCase();
            Vessel vessel =
                    new Vessel();

            vessel.setAssetId(vesselId);
            vessel.setAssetName(vesselName);
            vessel.setVesselCapacity(vesselCapacity);
            vessel.setAssetStatus(vesselStatus);
            vessel.setVesselFlag(vesselFlag);
            vessel.setVesselType(vesselType);

            vesselMap.put(
                    vesselId,
                    vessel
            );

            vesselQueue.offer(
                    vessel
            );

            System.out.println(
                    "Vessel Added Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void update() {

        int choice;

        System.out.println(
                "\n===== UPDATE VESSEL ====="
        );

        System.out.println(
                "1. Update Vessel Name"
        );

        System.out.println(
                "2. Update Vessel Capacity"
        );

        System.out.println(
                "3. Update Vessel Status"
        );
        System.out.println(
                "4. Update Vessel Type"
        );
        System.out.println(
                "5. Update Vessel Flag"
        );
        System.out.print(
                "Enter Choice : "
        );

        choice = scanner.nextInt();

        switch(choice) {

            case 1:
                updateVesselName();
                break;

            case 2:
                updateVesselCapacity();
                break;

            case 3:
                updateVesselStatus();
                break;

            case 4:
                updateVesselType();
                break;

            case 5:
                updateVesselFlag();
                break;

            default:
                System.out.println(
                        "Invalid Choice"
                );
        }
    }
    private void updateVesselFlag() {
        System.out.print(
                "Enter Vessel Id : "
        );
        try {
            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {
                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {
                System.out.println(
                        "Vessel Not Found"
                );
                return;
            }

            System.out.print(
                    "Enter New Vessel Flag : "
            );

            String vesselFlag =
                    scanner.next().toUpperCase();

            vessel.setVesselFlag(
                    vesselFlag
            );

            System.out.println(
                    "Vessel Flag Updated Successfully"
            );
        }
        catch(InvalidDataException msg) {
            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateVesselType() {
        System.out.print(
                "Enter Vessel Id : "
        );
        try {
            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {
                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {
                System.out.println(
                        "Vessel Not Found"
                );
                return;
            }

            System.out.print(
                    "Enter New Vessel Type : "
            );

            String vesselType =
                    scanner.next().toUpperCase();

            vessel.setVesselType(
                    vesselType
            );

            System.out.println(
                    "Vessel Type Updated Successfully"
            );
        }
        catch(InvalidDataException msg) {
            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateVesselName() {

        System.out.print(
                "Enter Vessel Id : "
        );

        try {

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Vessel Name : "
            );

            String vesselName =
                    scanner.nextLine().toUpperCase();

            vessel.setAssetName(
                    vesselName
            );

            System.out.println(
                    "Vessel Name Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    private void updateVesselCapacity() {

        System.out.print(
                "Enter Vessel Id : "
        );

        try {

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter New Capacity : "
            );

            double capacity =
                    scanner.nextDouble();

            vessel.setVesselCapacity(
                    capacity
            );

            System.out.println(
                    "Vessel Capacity Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateVesselStatus() {

        System.out.print(
                "Enter Vessel Id : "
        );

        try {

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status : ACTIVE\n" +
                            "INACTIVE\n" +
                            "DOCKED\n" +
                            "SAILING\n" +
                            "UNDER_MAINTENANCE\n" +
                            "DELAYED"
            );

            String status =
                    scanner.nextLine().toUpperCase();

            vessel.setAssetStatus(
                    status
            );

            System.out.println(
                    "Vessel Status Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    @Override
    public void delete() {

        System.out.print(
                "Enter Vessel Id : "
        );

        try {

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.remove(vesselId);

                vesselQueue.remove(vessel);

                System.out.println(
                        "Vessel Deleted Successfully"
                );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void findById() {

        System.out.print(
                "Enter Vessel Id : "
        );

        try {

            String vesselId =
                    scanner.next().toUpperCase();

            if(!regex.validateVesselId(vesselId)) {

                throw new InvalidDataException(
                        "Invalid Vessel Id. Format : VES001"
                );
            }

            Vessel vessel =
                    vesselMap.get(vesselId);

            if(vessel == null) {

                System.out.println(
                        "Vessel Not Found"
                );
            }
            else {

                System.out.println(
                        vessel
                );
            }

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void viewActiveVessels() {

        vesselMap.values()
                .stream()
                .filter(
                        vessel ->
                                vessel.getAssetStatus()
                                        .equalsIgnoreCase(
                                                "ACTIVE"
                                        )
                )
                .forEach(
                        System.out::println
                );
    }
    public void findDelayedVessels() {

        vesselMap.values()
                .stream()
                .filter(
                        vessel ->
                                vessel.getSchedule() != null
                                        &&
                                        vessel.getSchedule()
                                                .getScheduleStatus()
                                                .equalsIgnoreCase(
                                                        "DELAYED"
                                                )
                )
                .forEach(
                        System.out::println
                );
    }


    public void vesselAnalytics() {

        int choice;

        while (true){

            System.out.println(
                    "\n===== VESSEL ANALYTICS ====="
            );

            System.out.println(
                    "1. List Active Vessels"
            );

            System.out.println(
                    "2. Distinct Vessel Names"
            );

            System.out.println(
                    "3. Highest Capacity Vessel"
            );

            System.out.println(
                    "4. Lowest Capacity Vessel"
            );

            System.out.println(
                    "5. Priority Queue Head Vessel"
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
                            "\nActive Vessels"
                    );

                    vesselMap.values()
                            .stream()
                            .filter(
                                    vessel ->
                                            vessel.getAssetStatus()
                                                    .equalsIgnoreCase(
                                                            "ACTIVE"
                                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 2:

                    System.out.println(
                            "\nDistinct Vessel Names"
                    );

                    vesselMap.values()
                            .stream()
                            .map(
                                    Vessel::getAssetName
                            )
                            .distinct()
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nHighest Capacity Vessel"
                    );

                    vesselMap.values()
                            .stream()
                            .max(
                                    Comparator.comparing(
                                            Vessel::getVesselCapacity
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 4:

                    System.out.println(
                            "\nLowest Capacity Vessel"
                    );

                    vesselMap.values()
                            .stream()
                            .min(
                                    Comparator.comparing(
                                            Vessel::getVesselCapacity
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 5:

                    System.out.println(
                            "\nPriority Queue Head Vessel"
                    );

                    System.out.println(
                            vesselQueue.peek()
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
    public static HashMap<String, Vessel> getVesselMap() {

        return vesselMap;
    }

}
