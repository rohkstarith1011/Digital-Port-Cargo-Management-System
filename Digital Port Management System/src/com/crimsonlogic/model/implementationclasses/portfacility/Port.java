package com.crimsonlogic.model.implementationclasses.portfacility;

import com.crimsonlogic.model.abstractclasses.PortFacility;

import java.util.Objects;

public class Port extends PortFacility {
    private String city;
    private int totalBerths;
    private int totalYards;

    //Port HAS-A YARD , Port HAS-A Berth

    public Port() {
    }

    public Port(String facilityId, String facilityName, String facilityLocation, String facilityStatus, String city, int totalBerths, int totalYards) {
        super(facilityId, facilityName, facilityLocation, facilityStatus);
        this.city = city;
        this.totalBerths = totalBerths;
        this.totalYards = totalYards;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalBerths() {
        return totalBerths;
    }

    public void setTotalBerths(int totalBerths) {
        this.totalBerths = totalBerths;
    }

    public int getTotalYards() {
        return totalYards;
    }

    public void setTotalYards(int totalYards) {
        this.totalYards = totalYards;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "city='" + city + '\'' +
                ", totalBerths=" + totalBerths +
                ", totalYards=" + totalYards +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Port port = (Port) o;
        return totalBerths == port.totalBerths && totalYards == port.totalYards && Objects.equals(city, port.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, totalBerths, totalYards);
    }
}
