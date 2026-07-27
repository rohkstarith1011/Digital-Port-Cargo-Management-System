package com.crimsonlogic.service.management;

import com.crimsonlogic.exception.InvalidDataException;
import com.crimsonlogic.model.implementationclasses.user.Customer;
import com.crimsonlogic.service.interfaces.Manageable;
import com.crimsonlogic.utility.ValidationClass;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerManagement implements Manageable {

    ValidationClass regex = new ValidationClass();

    private static HashMap<String, Customer>
            customerMap =
            new HashMap<>();

    Scanner scanner = new Scanner(System.in);
    static {

        Customer c1 = new Customer();
        c1.setUserId("CUS001");
        c1.setUserName("ROHIT");
        c1.setUserEmail("ROHIT@GMAIL.COM");
        c1.setUserPhNo("9878765473");
        c1.setGSTNumber("12SDDDC8765AA8A");

        Customer c2 = new Customer();
        c2.setUserId("CUS002");
        c2.setUserName("AMIT");
        c2.setUserEmail("AMIT@GMAIL.COM");
        c2.setUserPhNo("9878765474");
        c2.setGSTNumber("12SDDDC8765AA8B");

        Customer c3 = new Customer();
        c3.setUserId("CUS003");
        c3.setUserName("PRIYA");
        c3.setUserEmail("PRIYA@GMAIL.COM");
        c3.setUserPhNo("9878765475");
        c3.setGSTNumber("12SDDDC8765AA8C");

        Customer c4 = new Customer();
        c4.setUserId("CUS004");
        c4.setUserName("KIRAN");
        c4.setUserEmail("KIRAN@GMAIL.COM");
        c4.setUserPhNo("9878765476");
        c4.setGSTNumber("12SDDDC8765AA8D");

        Customer c5 = new Customer();
        c5.setUserId("CUS005");
        c5.setUserName("SNEHA");
        c5.setUserEmail("SNEHA@GMAIL.COM");
        c5.setUserPhNo("9878765477");
        c5.setGSTNumber("12SDDDC8765AA8E");

        customerMap.put("CUS001", c1);
        customerMap.put("CUS002", c2);
        customerMap.put("CUS003", c3);
        customerMap.put("CUS004", c4);
        customerMap.put("CUS005", c5);
    }
    @Override
    public void add() {

        try {

            System.out.print(
                    "Enter Customer Id : "
            );

            String customerId =
                    scanner.next().toUpperCase();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            if (customerMap.containsKey(customerId)) {

                System.out.println(
                        "Customer Already Exists"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter Customer Name : "
            );

            String customerName =
                    scanner.nextLine().toUpperCase();

            System.out.print(
                    "Enter Email : "
            );

            String email =
                    scanner.nextLine();

            if (!regex.validateEmail(email)) {

                throw new InvalidDataException(
                        "Invalid Email Format"
                );
            }

            System.out.print(
                    "Enter Phone Number : "
            );

            String phoneNumber =
                    scanner.nextLine();

            if (!regex.validatePhoneNumber(phoneNumber)) {

                throw new InvalidDataException(
                        "Invalid Phone Number"
                );
            }

            System.out.print(
                    "Enter GST Number : "
            );

            String gstNumber =
                    scanner.nextLine();

            if (!regex.validateGSTNumber(gstNumber)) {

                throw new InvalidDataException(
                        "Invalid GST Number"
                );
            }

            Customer customer =
                    new Customer();

            customer.setUserId(customerId);
            customer.setUserName(customerName);
            customer.setUserEmail(email);
            customer.setUserPhNo(phoneNumber);
            customer.setGSTNumber(gstNumber);

            customerMap.put(
                    customerId,
                    customer
            );

            System.out.println(
                    "Customer Added Successfully"
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
                "\n===== UPDATE CUSTOMER ====="
        );

        System.out.println(
                "1. Update Customer Name"
        );

        System.out.println(
                "2. Update Email"
        );

        System.out.println(
                "3. Update Phone Number"
        );

        System.out.println(
                "4. Update GST Number"
        );

        System.out.print(
                "Enter Choice : "
        );

        choice = scanner.nextInt();

        switch(choice) {

            case 1:
                updateCustomerName();
                break;

            case 2:
                updateEmail();
                break;

            case 3:
                updatePhoneNumber();
                break;

            case 4:
                updateGSTNumber();
                break;

            default:
                System.out.println(
                        "Invalid Choice"
                );
        }
    }
    private void updatePhoneNumber() {

        System.out.print(
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next().toUpperCase();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Phone Number : "
            );

            String phoneNumber =
                    scanner.nextLine();

            if (!regex.validatePhoneNumber(phoneNumber)) {

                throw new InvalidDataException(
                        "Invalid Phone Number"
                );
            }

            customer.setUserPhNo(phoneNumber);

            System.out.println(
                    "Phone Number Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public static HashMap<String, Customer> getCustomerMap() {

        return customerMap;
    }
    private void updateGSTNumber() {

        System.out.print(
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New GST Number : "
            );

            String gstNumber =
                    scanner.nextLine();

            if (!regex.validateGSTNumber(gstNumber)) {

                throw new InvalidDataException(
                        "Invalid GST Number"
                );
            }

            customer.setGSTNumber(gstNumber);

            System.out.println(
                    "GST Number Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateEmail() {

        System.out.print(
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Email : "
            );

            String email =
                    scanner.nextLine();

            if (!regex.validateEmail(email)) {

                throw new InvalidDataException(
                        "Invalid Email Format"
                );
            }

            customer.setUserEmail(email);

            System.out.println(
                    "Email Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    private void updateCustomerName() {

        System.out.print(
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );

                return;
            }

            scanner.nextLine();

            System.out.print(
                    "Enter New Customer Name : "
            );

            String customerName =
                    scanner.nextLine();

            customer.setUserName(
                    customerName
            );

            System.out.println(
                    "Customer Name Updated Successfully"
            );

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    @Override
    public void delete() {

        System.out.print(
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next().toUpperCase();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.remove(customerId);

                System.out.println(
                        "Customer Deleted Successfully"
                );


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
                "Enter Customer Id : "
        );

        try {

            String customerId =
                    scanner.next().toUpperCase();

            if (!regex.validateCustomerId(customerId)) {

                throw new InvalidDataException(
                        "Invalid Customer Id. Format : CUS001"
                );
            }

            Customer customer =
                    customerMap.get(customerId);

            if (customer == null) {

                System.out.println(
                        "Customer Not Found"
                );
            }
            else {

                System.out.println(
                        customer
                );
            }

        }
        catch (InvalidDataException msg) {

            System.out.println(
                    msg.getMessage()
            );
        }
    }
    public void displayAllCustomers() {

        customerMap.values()
                .forEach(
                        System.out::println
                );
    }

    public void customerAnalytics() {

        int choice;

        while (true) {

            System.out.println(
                    "\n===== CUSTOMER ANALYTICS ====="
            );

            System.out.println(
                    "1. Total Customers"
            );

            System.out.println(
                    "2. Display Customer Names"
            );

            System.out.println(
                    "3. Distinct Email Domains"
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
                            "\nTotal Customers : "
                                    + customerMap.size()
                    );

                    break;

                case 2:

                    System.out.println(
                            "\nCustomer Names"
                    );

                    customerMap.values()
                            .stream()
                            .map(
                                    Customer::getUserName
                            )
                            .forEach(
                                    System.out::println
                            );

                    break;

                case 3:

                    System.out.println(
                            "\nDistinct Email Domains"
                    );

                    customerMap.values()
                            .stream()
                            .map(
                                    customer ->
                                            customer.getUserEmail()
                                                    .substring(
                                                            customer.getUserEmail()
                                                                    .indexOf("@") + 1
                                                    )
                            )
                            .distinct()
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
    }
}





