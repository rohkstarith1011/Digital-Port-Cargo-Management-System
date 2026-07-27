package com.crimsonlogic.service.operations;

import com.crimsonlogic.service.management.CargoManagement;
import com.crimsonlogic.service.management.ShipmentManagement;
import com.crimsonlogic.service.management.VesselManagement;

public class ReportManagement {

    public void cargoAnalytics() {

        CargoManagement cargoManagement =
                new CargoManagement();

        cargoManagement.cargoAnalytics();
    }

    public void vesselAnalytics() {

        VesselManagement vesselManagement =
                new VesselManagement();

        vesselManagement.vesselAnalytics();
    }

    public void berthAnalytics() {

        BerthManagement berthManagement =
                new BerthManagement();

        berthManagement.berthAnalytics();
    }

    public void shipmentAnalytics() {

        ShipmentManagement shipmentManagement =
                new ShipmentManagement();

        shipmentManagement.shipmentAnalytics();
    }

    public void revenueAnalytics() {

        ShipmentManagement shipmentManagement =
                new ShipmentManagement();

        shipmentManagement.shipmentAnalytics();
    }

    public void customsAnalytics() {

        CustomsManagement customsManagement =
                new CustomsManagement();

        customsManagement.customsAnalytics();
    }

    public void manifestAnalytics() {

        CargoManagement cargoManagement =
                new CargoManagement();

        cargoManagement.cargoAnalytics();
    }

    public void streamPerformanceAnalytics() {

        System.out.println(
                "\n===== STREAM PERFORMANCE ANALYTICS ====="
        );

        cargoAnalytics();

        vesselAnalytics();

        shipmentAnalytics();

        customsAnalytics();
    }
}