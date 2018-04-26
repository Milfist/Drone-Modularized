module com.testexec {
    requires junit;
    requires drone.module;
    requires org.mockito;
    uses com.drone.driver.Driver;
    uses com.drone.service.UrbanizationsTreatmentService;
    uses com.drone.service.UrbanizationsTreatmentSimulatedService;
//    exports com.test.driver to junit, org.mockito;
//    exports com.test.driver;
//    exports com.test.service to junit, org.mockito;
}