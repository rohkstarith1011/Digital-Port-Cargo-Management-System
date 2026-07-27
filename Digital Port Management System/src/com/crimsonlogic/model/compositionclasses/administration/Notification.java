package com.crimsonlogic.model.compositionclasses.administration;

import java.time.LocalDate;
import java.util.Objects;

public class Notification {
    private String notificationId;
    private String notificationType;
    private String message;
    private LocalDate notificationDate;
    private String notificationStatus;

    public Notification(String notificationStatus,String notificationId, String notificationType, String message, LocalDate notificationDate) {
        this.notificationId = notificationId;
        this.notificationType = notificationType;
        this.message = message;
        this.notificationDate = notificationDate;
        this.notificationStatus=notificationStatus;
    }

    public Notification() {
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDate notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "notificationId= " + notificationId +
                "\n notificationType= " + notificationType +
                "\n message= " + message +
                "\n notificationDate= " + notificationDate +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(notificationId, that.notificationId) && Objects.equals(notificationType, that.notificationType) && Objects.equals(message, that.message) && Objects.equals(notificationDate, that.notificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, notificationType, message, notificationDate);
    }
}
