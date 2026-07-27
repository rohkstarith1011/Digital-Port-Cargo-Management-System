package com.crimsonlogic.model.compositionclasses.administration;

import com.crimsonlogic.model.implementationclasses.user.Customer;

import java.util.Objects;

public class Invoice {
    private String invoiceId;
    private double cargoHandlingCharge;
    private double storageCharge;
    private double totalAmount;
    private String paymentStatus;

    //Invoice HAS-A Customer
    private Customer customer;

    public Invoice(String invoiceId, double cargoHandlingCharge, double storageCharge, double totalAmount, String paymentStatus, Customer customer) {
        this.invoiceId = invoiceId;
        this.cargoHandlingCharge = cargoHandlingCharge;
        this.storageCharge = storageCharge;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.customer = customer;
    }

    public Invoice() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getCargoHandlingCharge() {
        return cargoHandlingCharge;
    }

    public void setCargoHandlingCharge(double cargoHandlingCharge) {
        this.cargoHandlingCharge = cargoHandlingCharge;
    }

    public double getStorageCharge() {
        return storageCharge;
    }

    public void setStorageCharge(double storageCharge) {
        this.storageCharge = storageCharge;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {

        return "invoiceId= " + invoiceId +
                "\n cargoHandlingCharge= " + cargoHandlingCharge +
                "\n storageCharge=" + storageCharge +
                "\n totalAmount=" + totalAmount +
                "\n paymentStatus='" + paymentStatus +
                "\n customer={" + customer +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(cargoHandlingCharge, invoice.cargoHandlingCharge) == 0 && Double.compare(storageCharge, invoice.storageCharge) == 0 && Double.compare(totalAmount, invoice.totalAmount) == 0 && Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(paymentStatus, invoice.paymentStatus) && Objects.equals(customer, invoice.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, cargoHandlingCharge, storageCharge, totalAmount, paymentStatus, customer);
    }
}
