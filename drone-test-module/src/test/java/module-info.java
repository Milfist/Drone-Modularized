module com.test {
    requires junit;
    requires org.mockito;

    requires drone.module;

    uses com.drone.driver.Driver;
    uses com.drone.service.UrbanizationsTreatmentService;
    uses com.drone.service.UrbanizationsTreatmentSimulatedService;
}