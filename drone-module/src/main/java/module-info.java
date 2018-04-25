module drone.module {
    exports com.drone.common to drone.test, drone.app;
    exports com.drone.service to drone.test, drone.app;
    exports com.drone.driver to drone.test, drone.app;
    provides com.drone.service.UrbanizationsTreatmentService with com.drone.service.UrbanizationsTreatmentServiceImpl;
    provides com.drone.service.UrbanizationsTreatmentSimulatedService with com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
    provides com.drone.driver.Driver with com.drone.driver.DriverImpl;
}