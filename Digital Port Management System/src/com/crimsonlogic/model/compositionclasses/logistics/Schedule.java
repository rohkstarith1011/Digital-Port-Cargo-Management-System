package com.crimsonlogic.model.compositionclasses.logistics;

import com.crimsonlogic.model.implementationclasses.portfacility.Berth;
import com.crimsonlogic.model.implementationclasses.transportasset.Vessel;

import java.time.LocalDate;
import java.util.Objects;

public class Schedule {
    private String scheduleId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String scheduleStatus;
    //Schedule Has-A Vessel
    private Vessel vessel;
    //Schedule HAS-A Berth
    private Berth berth;

    public Schedule() {
    }

    public Schedule(String scheduleId, LocalDate arrivalDate, LocalDate departureDate, String scheduleStatus, Vessel vessel, Berth berth) {
        this.scheduleId = scheduleId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.scheduleStatus = scheduleStatus;
        this.vessel = vessel;
        this.berth = berth;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Berth getBerth() {
        return berth;
    }

    public void setBerth(Berth berth) {
        this.berth = berth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(scheduleId, schedule.scheduleId) && Objects.equals(arrivalDate, schedule.arrivalDate) && Objects.equals(departureDate, schedule.departureDate) && Objects.equals(scheduleStatus, schedule.scheduleStatus) && Objects.equals(vessel, schedule.vessel) && Objects.equals(berth, schedule.berth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, arrivalDate, departureDate, scheduleStatus, vessel, berth);
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "scheduleId='" + scheduleId +
                "\n arrivalDate=" + arrivalDate +
                "\n departureDate=" + departureDate +
                "\n scheduleStatus='" + scheduleStatus +
                "\n vessel={" + vessel +
                "}\n berth={" + berth +
                " }"+" ";
    }

}
