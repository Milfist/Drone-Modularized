package com.drone.driver;

import com.drone.common.Directions;
import com.drone.service.UrbanizationsTreatmentService;
import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
/**
 * @see Driver
 */
//@Slf4j
@NoArgsConstructor
public class DriverImpl implements Driver {

    private UrbanizationsTreatmentService service;

//    public DriverImpl() {
//    }

    /**
     * Driver class constructor
     * @param service instance of the service to be used. It can be a simulated or real service.
     */
    public DriverImpl(UrbanizationsTreatmentService service) {
        this.service = service;
    }

    /**
     * @see Driver#getUrbanizationId(Double, Double)
     */
    public String getUrbanizationId(Double coordinateX, Double coordinateY) {
        return this.service.getPositionByCoordinate(coordinateX, coordinateY);
    }

    /**
     * @see Driver#getAdjacent(String, Directions)
     */
    public String getAdjacent(String urbanizationId, Directions direction) {
        return this.service.getAdjacent(urbanizationId,direction.getValue());
    }
}
