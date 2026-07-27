package com.crimsonlogic.service.operations;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.compositionclasses.logistics.Schedule;
import com.crimsonlogic.service.interfaces.StatusManageable;
import com.crimsonlogic.utility.ValidationClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class ScheduleManagement implements StatusManageable {
     static ArrayList<Schedule> scheduleList =
            new ArrayList<>();
    ValidationClass regex =
            new ValidationClass();

    Scanner scanner =
            new Scanner(System.in);
    static {

        Schedule sch1 = new Schedule();
        sch1.setScheduleId("SCH001");
        sch1.setArrivalDate(LocalDate.of(2026,7,28));
        sch1.setDepartureDate(LocalDate.of(2026,7,29));
        sch1.setScheduleStatus("SCHEDULED");

        Schedule sch2 = new Schedule();
        sch2.setScheduleId("SCH002");
        sch2.setArrivalDate(LocalDate.of(2026,8,1));
        sch2.setDepartureDate(LocalDate.of(2026,8,2));
        sch2.setScheduleStatus("ARRIVED");

        Schedule sch3 = new Schedule();
        sch3.setScheduleId("SCH003");
        sch3.setArrivalDate(LocalDate.of(2026,8,5));
        sch3.setDepartureDate(LocalDate.of(2026,8,6));
        sch3.setScheduleStatus("DELAYED");

        Schedule sch4 = new Schedule();
        sch4.setScheduleId("SCH004");
        sch4.setArrivalDate(LocalDate.of(2026,8,10));
        sch4.setDepartureDate(LocalDate.of(2026,8,12));
        sch4.setScheduleStatus("DEPARTED");

        Schedule sch5 = new Schedule();
        sch5.setScheduleId("SCH005");
        sch5.setArrivalDate(LocalDate.of(2026,8,15));
        sch5.setDepartureDate(LocalDate.of(2026,8,17));
        sch5.setScheduleStatus("SCHEDULED");

        scheduleList.add(sch1);
        scheduleList.add(sch2);
        scheduleList.add(sch3);
        scheduleList.add(sch4);
        scheduleList.add(sch5);
    }

    public static ArrayList<Schedule> getScheduleList() {

        return scheduleList;
    }
    @Override

    public void updateStatus() {

        scanner.nextLine();

        System.out.print(
                "Enter Schedule Id : "
        );

        try {

            String scheduleId =
                    scanner.nextLine().toUpperCase();

            if(!regex.validateScheduleId(scheduleId)) {

                throw new InvalidDataException(
                        "Invalid Schedule Id. Format : SCH001"
                );
            }

            Schedule schedule =
                    scheduleList.stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule.getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(schedule == null) {

                System.out.println(
                        "Schedule Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter New Status : SCHEDULED\n" +
                            "DOCKED\n" +
                            "DEPARTED\n" +
                            "DELAYED "
            );

            String status =
                    scanner.nextLine().toUpperCase();

            schedule.setScheduleStatus(
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
     public void scheduleArrival() {

        scanner.nextLine();

        System.out.print(
                "Enter Schedule Id : "
        );

        try {

            String scheduleId =
                    scanner.nextLine().toUpperCase();

            if(!regex.validateScheduleId(scheduleId)) {

                throw new InvalidDataException(
                        "Invalid Schedule Id. Format : SCH001"
                );
            }

            Schedule schedule =
                    scheduleList.stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule.getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(schedule == null) {

                System.out.println(
                        "Schedule Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter Arrival Date (yyyy-MM-dd) : "
            );

            LocalDate arrivalDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            schedule.setArrivalDate(
                    arrivalDate
            );

            System.out.println(
                    "Arrival Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void scheduleDeparture() {

        scanner.nextLine();

        System.out.print(
                "Enter Schedule Id : "
        );

        try {

            String scheduleId =
                    scanner.nextLine().toUpperCase();

            if(!regex.validateScheduleId(scheduleId)) {

                throw new InvalidDataException(
                        "Invalid Schedule Id. Format : SCH001"
                );
            }

            Schedule schedule =
                    scheduleList.stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule.getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst()
                            .orElse(null);

            if(schedule == null) {

                System.out.println(
                        "Schedule Not Found"
                );

                return;
            }

            System.out.print(
                    "Enter Departure Date (yyyy-MM-dd) : "
            );

            LocalDate departureDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            schedule.setDepartureDate(
                    departureDate
            );

            System.out.println(
                    "Departure Updated Successfully"
            );

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void createSchedule() {

        try {



            System.out.print(
                    "Enter Schedule Id : "
            );

            String scheduleId =
                    scanner.nextLine().toUpperCase();

            if (!regex.validateScheduleId(scheduleId)) {

                throw new InvalidDataException(
                        "Invalid Schedule Id. Format : SCH001"
                );
            }

            System.out.print(
                    "Enter Arrival Date (yyyy-MM-dd) : "
            );

            LocalDate arrivalDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            System.out.print(
                    "Enter Departure Date (yyyy-MM-dd) : "
            );

            LocalDate departureDate =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            if (departureDate.isBefore(arrivalDate)) {

                System.out.println(
                        "Departure Date Cannot Be Before Arrival Date"
                );

                return;
            }

            Schedule schedule =
                    new Schedule();

            schedule.setScheduleId(
                    scheduleId
            );

            schedule.setArrivalDate(
                    arrivalDate
            );

            schedule.setDepartureDate(
                    departureDate
            );

            schedule.setScheduleStatus(
                    "SCHEDULED"
            );

            scheduleList.add(schedule);

            System.out.println(
                    "Schedule Created Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
     public void findScheduleById() {

        scanner.nextLine();

        System.out.print(
                "Enter Schedule Id : "
        );

        try {

            String scheduleId =
                    scanner.nextLine().toUpperCase();

            if(!regex.validateScheduleId(scheduleId)) {

                throw new InvalidDataException(
                        "Invalid Schedule Id. Format : SCH001"
                );
            }

            Optional<Schedule> schedule =
                    scheduleList.stream()
                            .filter(
                                    currentSchedule ->
                                            currentSchedule.getScheduleId()
                                                    .equalsIgnoreCase(
                                                            scheduleId
                                                    )
                            )
                            .findFirst();

            if(schedule.isPresent()) {

                System.out.println(
                        schedule.get()
                );
            }
            else {

                System.out.println(
                        "Schedule Not Found"
                );
            }

        }
        catch(InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void checkScheduleConflict() {

        System.out.print(
                "Enter Arrival Date (yyyy-MM-dd) : "
        );

        LocalDate arrivalDate =
                LocalDate.parse(
                        scanner.next()
                );

        boolean conflictFound =
                scheduleList.stream()
                        .anyMatch(
                                schedule ->
                                        schedule.getArrivalDate()
                                                .equals(arrivalDate)
                        );

        if (conflictFound) {

            System.out.println(
                    "Schedule Conflict Found"
            );
        }
        else {

            System.out.println(
                    "No Conflict Found"
            );
        }
    }
    //advance requirement
    public void adjustScheduleByWeather() {

        scanner.nextLine();

        System.out.print(
                "Enter Weather Condition : STORM\n" +
                        "RAIN\n" +
                        "NORMAL"
        );

        String weather =
                scanner.nextLine().toUpperCase();

        switch (weather.toUpperCase()) {

            case "STORM":

                scheduleList.forEach(
                        schedule ->
                                schedule.setScheduleStatus(
                                        "DELAYED"
                                )
                );

                System.out.println(
                        "All Schedules Delayed Due To Storm"
                );

                break;

            case "RAIN":

                scheduleList.forEach(
                        schedule ->
                                schedule.setScheduleStatus(
                                        "DELAYED"
                                )
                );

                System.out.println(
                        "Schedules Delayed Due To Rain"
                );

                break;

            case "NORMAL":

                System.out.println(
                        "Schedules Running Normally"
                );

                break;

            default:

                System.out.println(
                        "Invalid Weather Condition"
                );
        }
    }
    public void scheduleAnalytics() {

        int choice;

        while(true){

            System.out.println(
                    "\n===== SCHEDULE ANALYTICS ====="
            );

            System.out.println(
                    "1. Sort By Arrival Date"
            );

            System.out.println(
                    "2. Earliest Arrival"
            );

            System.out.println(
                    "3. Latest Departure"
            );

            System.out.println(
                    "4. Delayed Schedules"
            );

            System.out.println(
                    "0. Back"
            );

            choice = scanner.nextInt();

            switch(choice) {

                case 1:

                    scheduleList.stream()
                            .sorted(
                                    Comparator.comparing(
                                            Schedule::getArrivalDate
                                    )
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 2:

                    scheduleList.stream()
                            .min(
                                    Comparator.comparing(
                                            Schedule::getArrivalDate
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 3:

                    scheduleList.stream()
                            .max(
                                    Comparator.comparing(
                                            Schedule::getDepartureDate
                                    )
                            )
                            .ifPresent(
                                    System.out::println
                            );

                    break;

                case 4:

                    scheduleList.stream()
                            .filter(
                                    schedule ->
                                            schedule.getScheduleStatus()
                                                    .equalsIgnoreCase(
                                                            "DELAYED"
                                                    )
                            )
                            .forEach(
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
        //        5. Sort vessels by arrival time
//
//        22. Earliest arriving vessel
//
//        23. Latest departing vessel
//
//        24. Find delayed vessels
    }


}
