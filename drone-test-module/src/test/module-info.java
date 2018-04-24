module Drone {

    exports com.drone.driver;
    exports com.drone.common;
    provides com.drone.service.UrbanizationsTreatmentService with com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
}