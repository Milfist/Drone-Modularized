module drone.test {
    requires junit;
    requires drone.module;
    requires org.mockito;
    uses com.drone.driver.Driver;
    uses com.drone.service.UrbanizationsTreatmentService;
    uses com.drone.service.UrbanizationsTreatmentSimulatedService;
//    exports com.test.driver.
//    exports com.test.driver to junit;
//    exports com.test.service to junit;
}