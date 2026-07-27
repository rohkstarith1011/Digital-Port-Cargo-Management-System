package com.crimsonlogic.service.management;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.compositionclasses.logistics.Cargo;
import com.crimsonlogic.service.interfaces.Manageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.*;
import java.util.stream.Collectors;

public class CargoManagement implements Manageable {
    ValidationClass regex=new ValidationClass();
    private static HashMap<String, Cargo> cargoMap=new HashMap<>();
   Scanner scanner=new Scanner(System.in);


    public static HashMap<String, Cargo> getCargoMap() {

        return cargoMap;
    }


    static {

        Cargo cargo1 = new Cargo();
        cargo1.setCargoId("CAR001");
        cargo1.setCargoName("ROHINFRA");
        cargo1.setCargoType("GENERAL");
        cargo1.setCargoWeight(1000);
        cargo1.setDestination("SINGAPORE");
        cargo1.setHazardous(false);
        cargo1.setCargoStatus("PENDING");

        Cargo cargo2 = new Cargo();
        cargo2.setCargoId("CAR002");
        cargo2.setCargoName("CHEMLOG");
        cargo2.setCargoType("HAZARDOUS");
        cargo2.setCargoWeight(2500);
        cargo2.setDestination("DUBAI");
        cargo2.setHazardous(true);
        cargo2.setCargoStatus("IN_TRANSIT");

        Cargo cargo3 = new Cargo();
        cargo3.setCargoId("CAR003");
        cargo3.setCargoName("AUTOMOTIVE");
        cargo3.setCargoType("AUTOMOBILE");
        cargo3.setCargoWeight(4500);
        cargo3.setDestination("SINGAPORE");
        cargo3.setHazardous(false);
        cargo3.setCargoStatus("DELIVERED");

        Cargo cargo4 = new Cargo();
        cargo4.setCargoId("CAR004");
        cargo4.setCargoName("FROZENFOODS");
        cargo4.setCargoType("PERISHABLE");
        cargo4.setCargoWeight(800);
        cargo4.setDestination("MALAYSIA");
        cargo4.setHazardous(false);
        cargo4.setCargoStatus("PENDING");

        Cargo cargo5 = new Cargo();
        cargo5.setCargoId("CAR005");
        cargo5.setCargoName("ELECTROWORLD");
        cargo5.setCargoType("ELECTRONICS");
        cargo5.setCargoWeight(3200);
        cargo5.setDestination("DUBAI");
        cargo5.setHazardous(false);
        cargo5.setCargoStatus("DELIVERED");

        cargoMap.put("CAR001", cargo1);
        cargoMap.put("CAR002", cargo2);
        cargoMap.put("CAR003", cargo3);
        cargoMap.put("CAR004", cargo4);
        cargoMap.put("CAR005", cargo5);
    }
    @Override
    public void add() {


        try {

            System.out.print("Enter Cargo Id : ");
            String cargoId = scanner.next().toUpperCase();

            if (!regex.validateCargoId(cargoId)) {
                throw new InvalidDataException(
                        "Invalid Cargo Id. Format : CAR001");
            }

            if (cargoMap.containsKey(cargoId)) {

                System.out.println(
                        "Cargo Already Exists");

                return;
            }

            scanner.nextLine();

            System.out.print("Enter Cargo Name : ");
            String cargoName = scanner.nextLine().toUpperCase();

            System.out.print("Enter Cargo Type : ");
            String cargoType = scanner.nextLine().toUpperCase();

            System.out.print("Enter Cargo Weight : ");
            double cargoWeight = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Enter Destination : ");
            String destination = scanner.nextLine().toUpperCase();

            System.out.print("Is Hazardous (type false for non hazardous" +
                    "\n or true for hazardous" +
                    " and press enter) : ");
            boolean hazardous = scanner.nextBoolean();


            System.out.print("Enter Cargo Status :PENDING\n" +
                    "LOADED\n" +
                    "IN_TRANSIT\n" +
                    "ARRIVED\n" +
                    "DELIVERED\n" +
                    "DELAYED\n" +
                    "CUSTOMS_HOLD: ");
            String cargoStatus = scanner.next().toUpperCase();

            Cargo cargo = new Cargo();

            cargo.setCargoId(cargoId);
            cargo.setCargoName(cargoName);
            cargo.setCargoType(cargoType);
            cargo.setCargoWeight(cargoWeight);
            cargo.setDestination(destination);
            cargo.setHazardous(hazardous);
            cargo.setCargoStatus(cargoStatus);

            cargoMap.put(cargoId, cargo);

            System.out.println(
                    "Cargo Added Successfully.");

        }
        catch (Exception exception) {

            System.out.println(
                    exception.getMessage());
        }
    }

    @Override
    public void update() {

        int choice;

        System.out.println("\n===== UPDATE CARGO =====");

        System.out.println("1. Update Cargo Name");
        System.out.println("2. Update Cargo Weight");
        System.out.println("3. Update Destination");
        System.out.println("4. Update Cargo Status");

        System.out.print("Enter Choice : ");

        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                updateCargoName();
                break;

            case 2:
                updateCargoWeight();
                break;

            case 3:
                updateDestination();
                break;

            case 4:
                updateCargoStatus();
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    private void updateCargoName() {

        System.out.print("Enter Cargo Id : ");
        try {
            String cargoId = scanner.next().toUpperCase();
            if (!regex.validateCargoId(cargoId)) {
                throw new InvalidDataException(
                        "Invalid Cargo Id. Format : CAR001");
            }
            Cargo cargo = cargoMap.get(cargoId);

            if (cargo == null) {

                System.out.println("Cargo Not Found");

                return;
            }

            scanner.nextLine();

            System.out.print("Enter New Cargo Name : ");

            String cargoName = scanner.nextLine().toUpperCase();

            cargo.setCargoName(cargoName);

            System.out.println(
                    "Cargo Name Updated Successfully");

        }
        catch (InvalidDataException msg){
            System.out.println(msg.getMessage());
        }
        }
    private void updateCargoWeight() {

        System.out.print("Enter Cargo Id : ");
        try{
        String cargoId = scanner.next().toUpperCase();
            if (!regex.validateCargoId(cargoId)) {
                throw new InvalidDataException(
                        "Invalid Cargo Id. Format : CAR001");
            }
        Cargo cargo = cargoMap.get(cargoId);

        if (cargo == null) {

            System.out.println("Cargo Not Found");

            return;
        }

        System.out.print("Enter New Weight : ");

        double cargoWeight = scanner.nextDouble();

        cargo.setCargoWeight(cargoWeight);

        System.out.println(
                "Cargo Weight Updated Successfully");
    }catch (InvalidDataException msg){
            System.out.println(msg.getMessage());
        }
    }
    private void updateDestination() {

        System.out.print("Enter Cargo Id : ");
try {
    String cargoId = scanner.next().toUpperCase();
    if (!regex.validateCargoId(cargoId)) {
        throw new InvalidDataException(
                "Invalid Cargo Id. Format : CAR001");
    }
    Cargo cargo = cargoMap.get(cargoId);

    if (cargo == null) {

        System.out.println("Cargo Not Found");

        return;
    }

    scanner.nextLine();

    System.out.print("Enter New Destination : ");

    String destination = scanner.nextLine().toUpperCase();

    cargo.setDestination(destination);

    System.out.println(
            "Destination Updated Successfully");
}catch(InvalidDataException msg){
    System.out.println(msg.getMessage());
}
    }
    private void updateCargoStatus() {

        System.out.print("Enter Cargo Id : ");
     try {
         String cargoId = scanner.next().toUpperCase();
         if (!regex.validateCargoId(cargoId)) {
             throw new InvalidDataException(
                     "Invalid Cargo Id. Format : CAR001");
         }
         Cargo cargo = cargoMap.get(cargoId);

         if (cargo == null) {

             System.out.println("Cargo Not Found");

             return;
         }

         scanner.nextLine();

         System.out.print("Enter New Status : ");

         String status = scanner.nextLine().toUpperCase();

         cargo.setCargoStatus(status);

         System.out.println(
                 "Cargo Status Updated Successfully");
     }catch (InvalidDataException msg){
         System.out.println(msg.getMessage());
     }
     }
    @Override
    public void delete() {

        System.out.print("Enter Cargo Id : ");
        try {
            String cargoId = scanner.next().toUpperCase();
            if (!regex.validateCargoId(cargoId)) {
                throw new InvalidDataException(
                        "Invalid Cargo Id. Format : CAR001");
            }
            Cargo cargo = cargoMap.remove(cargoId);
                System.out.println(
                        "Cargo Deleted Successfully");

        }catch(InvalidDataException msg){
            System.out.println(msg.getMessage());
        }
    }

    @Override
    public void findById() {

        System.out.print("Enter Cargo Id : ");

        String cargoId = scanner.next().toUpperCase();

        Cargo cargo = cargoMap.get(cargoId);

        if (cargo == null) {

            System.out.println(
                    "Cargo Not Found");
        }
        else {

            System.out.println(cargo);
        }
    }
    public void trackCargoStatus() {

        System.out.print("Enter Cargo Id : ");
        try {
            String cargoId = scanner.next().toUpperCase();
            if (!regex.validateCargoId(cargoId)) {
                throw new InvalidDataException(
                        "Invalid Cargo Id. Format : CAR001");
            }
            Cargo cargo = cargoMap.get(cargoId);

            if (cargo == null) {

                System.out.println(
                        "Cargo Not Found");
            } else {

                System.out.println(
                        "Cargo Status : "
                                + cargo.getCargoStatus());
            }
        }catch (InvalidDataException msg){
            System.out.println(msg.getMessage());
        }
    }

    public void searchCargoByCustomer() {

        scanner.nextLine();

        System.out.print("Enter Customer Name : ");

        String customerName =
                scanner.nextLine().toUpperCase();

        cargoMap.values()
                .stream()
                .filter(
                        cargo ->
                                cargo.getCustomer()
                                        .getUserName()
                                        .equalsIgnoreCase(
                                                customerName
                                        )
                )
                .forEach(
                        System.out::println
                );

    }
    public void searchCargoByVessel() {

        scanner.nextLine();

        System.out.print("Enter Vessel Name : ");

        String vesselName =
                scanner.nextLine().toUpperCase();

        cargoMap.values()
                .stream()
                .filter(
                        cargo ->
                                cargo.getShipment()
                                        .getVessel()
                                        .getAssetName()
                                        .equalsIgnoreCase(
                                                vesselName
                                        )
                )
                .forEach(
                        System.out::println
                );
    }
    public void cargoAnalytics() {

        int choice;

        while (true) {

            System.out.println(
                    "\n===== CARGO ANALYTICS ====="
            );

            System.out.println(
                    "1. Filter Hazardous Cargo"
            );

            System.out.println(
                    "2. Sort Cargo By Weight"
            );

            System.out.println(
                    "3. Top 5 Heaviest Cargo"
            );

            System.out.println(
                    "4. Total Cargo Weight"
            );

            System.out.println(
                    "5. Average Cargo Weight"
            );

            System.out.println(
                    "6. Group Cargo By Destination"
            );

            System.out.println(
                    "7. Group Cargo By Customer"
            );

            System.out.println(
                    "8. Distinct Destinations"
            );

            System.out.println(
                    "9. Cargo Weight Statistics"
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
                            "\nHazardous Cargo"
                    );

                    cargoMap.values()
                            .stream()
                            .filter(
                                    Cargo::isHazardous
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 2:

                    System.out.println(
                            "\nSorted Cargo By Weight"
                    );

                    cargoMap.values()
                            .stream()
                            .sorted(
                                    Comparator.comparing(
                                            Cargo::getCargoWeight
                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nTop 5 Heaviest Cargo"
                    );

                    cargoMap.values()
                            .stream()
                            .sorted(
                                    Comparator.comparing(
                                            Cargo::getCargoWeight
                                    ).reversed()
                            )
                            .limit(5)
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 4:

                    double totalWeight =
                            cargoMap.values()
                                    .stream()
                                    .mapToDouble(
                                            Cargo::getCargoWeight
                                    )
                                    .sum();

                    System.out.println(
                            "Total Cargo Weight : "
                                    + totalWeight
                    );

                    break;

                case 5:

                    double averageWeight =
                            cargoMap.values()
                                    .stream()
                                    .mapToDouble(
                                            Cargo::getCargoWeight
                                    )
                                    .average()
                                    .orElse(0);

                    System.out.println(
                            "Average Cargo Weight : "
                                    + averageWeight
                    );

                    break;

                case 6:

                    System.out.println(
                            "\nGroup Cargo By Destination"
                    );

                    cargoMap.values()
                            .stream()
                            .collect(
                                    Collectors.groupingBy(
                                            Cargo::getDestination
                                    )
                            )
                            .forEach(
                                    (destination, cargoList) ->
                                            System.out.println(
                                                    destination
                                                            + " -> "
                                                            + cargoList
                                            )
                            );

                    break;

                case 7:

                    System.out.println(
                            "\nGroup Cargo By Customer"
                    );

                    cargoMap.values()
                            .stream()
                            .filter(
                                    cargo ->
                                            cargo.getCustomer() != null
                            )
                            .collect(
                                    Collectors.groupingBy(
                                            cargo ->
                                                    cargo.getCustomer()
                                                            .getUserName()
                                    )
                            )
                            .forEach(
                                    (customer, cargoList) ->
                                            System.out.println(
                                                    customer
                                                            + " -> "
                                                            + cargoList
                                            )
                            );

                    break;

                case 8:

                    System.out.println(
                            "\nDistinct Destinations"
                    );

                    cargoMap.values()
                            .stream()
                            .map(
                                    Cargo::getDestination
                            )
                            .distinct()
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 9:

                    System.out.println(
                            "\nCargo Weight Statistics"
                    );

                    DoubleSummaryStatistics statistics =
                            cargoMap.values()
                                    .stream()
                                    .collect(
                                            Collectors.summarizingDouble(
                                                    Cargo::getCargoWeight
                                            )
                                    );

                    System.out.println(
                            statistics
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
//
//        33 Optional lookup
public void optionalCargoLookup() {

    System.out.print("Enter Cargo Id : ");
    try {
        String cargoId = scanner.next().toUpperCase();
        if (!regex.validateCargoId(cargoId)) {
            throw new InvalidDataException(
                    "Invalid Cargo Id. Format : CAR001");
        }
        Optional<Cargo> optionalCargo = Optional.ofNullable(cargoMap.get(cargoId));

        optionalCargo.ifPresentOrElse(System.out::println,
                () -> System.out.println("Cargo Not Found")
        );
    }catch(InvalidDataException msg){
        System.out.println(msg.getMessage());
    }
}

}
