package com.app;

import com.drone.service.UrbanizationsTreatmentService;

import java.util.ServiceLoader;

public class Main {

    private static UrbanizationsTreatmentService service = ServiceLoader.load(UrbanizationsTreatmentService.class).findFirst().get();

    public Main() {}

    public static void main(String[] args) {


        String result = service.getPositionByCoordinate(null, null);

    }

}
