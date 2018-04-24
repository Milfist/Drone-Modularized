module com.drone {
    exports com.drone.driver;
    exports com.drone.common;
    provides com.drone.service.UrbanizationsTreatmentService with com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
    provides com.drone.service.UrbanizationsTreatmentSimulatedService with com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
}