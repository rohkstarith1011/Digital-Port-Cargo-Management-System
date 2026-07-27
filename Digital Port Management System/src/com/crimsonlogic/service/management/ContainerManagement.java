package com.crimsonlogic.service.management;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.implementationclasses.transportasset.Container;
import com.crimsonlogic.service.interfaces.Manageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ContainerManagement implements Manageable {
    private static ConcurrentHashMap<String, Container> containerMap =
            new ConcurrentHashMap<>();
    Scanner scanner=new Scanner(System.in);
    ValidationClass regex=new ValidationClass();
    @Override
    public void add() {

        try {

            System.out.print(
                    "Enter Container Id : "
            );

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            if (containerMap.containsKey(containerId)) {

                System.out.println(
                        "Container Already Exists"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Container Name : "
            );

            String containerName =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Container Type : "
            );

            String containerType =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Container Capacity : "
            );

            double containerCapacity =
                    scanner.nextDouble();

            scanner.nextLine();

            System.out.print(
                    "Enter Container Status : "
            );

            String containerStatus =
                    scanner.nextLine().toUpperCase();

            Container container =
                    new Container();

            container.setAssetId(
                    containerId
            );

            container.setAssetName(
                    containerName
            );

            container.setContainerType(
                    containerType
            );

            container.setMaxCapacity(
                    containerCapacity
            );

            container.setAssetStatus(
                    containerStatus
            );

            containerMap.put(
                    containerId,
                    container
            );

            System.out.println(
                    "Container Added Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void update() {

        int choice;

        System.out.println(
                "\n===== UPDATE CONTAINER ====="
        );

        System.out.println(
                "1. Update Container Type"
        );

        System.out.println(
                "2. Update Container Capacity"
        );

        System.out.println(
                "3. Update Container Status"
        );

        System.out.print(
                "Enter Choice : "
        );

        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                updateContainerType();
                break;

            case 2:
                updateContainerCapacity();
                break;

            case 3:
                updateContainerStatus();
                break;

            default:
                System.out.println(
                        "Invalid Choice"
                );
        }
    }
    private void updateContainerStatus() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Status : "
            );

            String status =
                    scanner.nextLine().toUpperCase();

            container.setAssetStatus(
                    status
            );

            System.out.println(
                    "Container Status Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateContainerCapacity() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter New Capacity : "
            );

            double capacity =
                    scanner.nextDouble();

            container.setMaxCapacity(
                    capacity
            );

            System.out.println(
                    "Container Capacity Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateContainerType() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Container Type : "
            );

            String containerType =
                    scanner.nextLine().toUpperCase();

            container.setContainerType(
                    containerType
            );

            System.out.println(
                    "Container Type Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void viewAvailableContainers(){

        containerMap.values()
                .stream().filter(container -> container.getAssetStatus().
                        equalsIgnoreCase("available"))
                .forEach(System.out::println);
    }
    @Override
    public void delete() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.remove(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );
            }
            else {

                System.out.println(
                        "Container Deleted Successfully"
                );
            }

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }

    @Override
    public void findById() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );
            }
            else {

                System.out.println(
                        container
                );
            }

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void assignContainerToYard() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter Yard Id : "
            );

            String yardId =
                    scanner.next();

            if (!regex.validateYardId(yardId)) {

                throw new InvalidDataException(
                        "Invalid Yard Id. Format : YAR001"
                );
            }
            containerMap.put(yardId,container);
            System.out.println(
                    "Container Assigned To Yard Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void removeContainerFromYard() {

        System.out.print(
                "Enter Container Id : "
        );

        try {

            String containerId =
                    scanner.next().toUpperCase();

            if (!regex.validateContainerId(containerId)) {

                throw new InvalidDataException(
                        "Invalid Container Id. Format : CON001"
                );
            }

            Container container =
                    containerMap.get(containerId);

            if (container == null) {

                System.out.println(
                        "Container Not Found"
                );

                return;
            }

            container.setAssetStatus(
                    "AVAILABLE"
            );

            System.out.println(
                    "Container Removed From Yard Successfully"
            );

        }
        catch (InvalidDataException ex) {

            System.out.println(
                    ex.getMessage()
            );
        }
    }

    public void searchContainerByType() {

        scanner.nextLine();

        System.out.print(
                "Enter Container Type : "
        );

        String containerType =
                scanner.nextLine();

        List<Container> containers =
                containerMap.values()
                        .stream()
                        .filter(
                                container ->
                                        container.getContainerType()
                                                .equalsIgnoreCase(
                                                        containerType
                                                )
                        )
                        .toList();

        if(containers.isEmpty()) {

            System.out.println(
                    "No Containers Found"
            );

            return;
        }

        containers.forEach(
                System.out::println
        );
    }
    public void containerAnalytics() {

        int choice;

        while (true) {

            System.out.println(
                    "\n===== CONTAINER ANALYTICS ====="
            );

            System.out.println(
                    "1. Count Containers By Type"
            );

            System.out.println(
                    "2. List Available Containers"
            );

            System.out.println(
                    "3. List Occupied Containers"
            );

            System.out.println(
                    "4. Container Capacity Statistics"
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
                            "\nCount Containers By Type"
                    );

                    containerMap.values()
                            .stream()
                            .collect(
                                    Collectors.groupingBy(
                                            Container::getContainerType,
                                            Collectors.counting()
                                    )
                            )
                            .forEach(
                                    (type, count) ->
                                            System.out.println(
                                                    type + " : " + count
                                            )
                            );

                    break;

                case 2:

                    System.out.println(
                            "\nAvailable Containers"
                    );

                    containerMap.values()
                            .stream()
                            .filter(
                                    container ->
                                            container.getAssetStatus()
                                                    .equalsIgnoreCase(
                                                            "AVAILABLE"
                                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nOccupied Containers"
                    );

                    containerMap.values()
                            .stream()
                            .filter(
                                    container ->
                                            container.getAssetStatus()
                                                    .equalsIgnoreCase(
                                                            "OCCUPIED"
                                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 4:

                    System.out.println(
                            "\nContainer Capacity Statistics"
                    );

                    DoubleSummaryStatistics statistics =
                            containerMap.values()
                                    .stream()
                                    .mapToDouble(
                                            Container::getMaxCapacity
                                    )
                                    .summaryStatistics();

                    System.out.println(
                            "Count : "
                                    + statistics.getCount()
                    );

                    System.out.println(
                            "Average : "
                                    + statistics.getAverage()
                    );

                    System.out.println(
                            "Maximum : "
                                    + statistics.getMax()
                    );

                    System.out.println(
                            "Minimum : "
                                    + statistics.getMin()
                    );

                    System.out.println(
                            "Sum : "
                                    + statistics.getSum()
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
//        Count containers by type
//
//        Available containers
//
//        Occupied containers
//
//        Container utilization
//
//        Container capacity statistics
    }


