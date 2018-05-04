package com.app;

import com.drone.service.UrbanizationsTreatmentService;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        UrbanizationsTreatmentService service = ServiceLoader.load(UrbanizationsTreatmentService.class).findFirst().get();

        service.getPositionByCoordinate(null, null);

    }

    public Main() {}
}
