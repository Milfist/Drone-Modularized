module drone.module {
    requires lombok;
    exports com.drone.common to com.test, drone.app, com.testexec;
    exports com.drone.service to com.test, drone.app, com.testexec;
    exports com.drone.driver to com.test, drone.app, com.testexec;
    provides com.drone.service.UrbanizationsTreatmentService with com.drone.service.UrbanizationsTreatmentServiceImpl;
    provides com.drone.service.UrbanizationsTreatmentSimulatedService with com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
    provides com.drone.driver.Driver with com.drone.driver.DriverImpl;
}