package com.crimsonlogic.model.implementationclasses.user;

import com.crimsonlogic.model.abstractclasses.User;
import com.crimsonlogic.model.implementationclasses.portfacility.Yard;

import java.util.Objects;

public class YardOperator extends User {
    private String equipmentType;
    //YardOperator HAS-A Yard
    private Yard assignedYard;

    public YardOperator() {
    }

    public YardOperator(String userId, String userName, String userEmail, String userPhNo, String equipmentType, Yard assignedYard) {
        super(userId, userName, userEmail, userPhNo);
        this.equipmentType = equipmentType;
        this.assignedYard = assignedYard;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Yard getAssignedYard() {
        return assignedYard;
    }

    public void setAssignedYard(Yard assignedYard) {
        this.assignedYard = assignedYard;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "equipmentType='" + equipmentType + '\'' +
                ", assignedYard=" + assignedYard +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        YardOperator that = (YardOperator) o;
        return Objects.equals(equipmentType, that.equipmentType) && Objects.equals(assignedYard, that.assignedYard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipmentType, assignedYard);
    }
}
